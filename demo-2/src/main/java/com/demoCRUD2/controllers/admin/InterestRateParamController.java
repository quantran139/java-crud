package com.demoCRUD2.controllers.admin;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demoCRUD2.ExcelGenerator;
import com.demoCRUD2.models.InterestRateParam;
import com.demoCRUD2.services.InterestRateParamService;

import DTO.InterestRateParamDTO;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")
public class InterestRateParamController {
	@Autowired
	private InterestRateParamService interestRateParamService;

	@GetMapping("/interestRateParam")
	public String index(Model model) {
		List<InterestRateParamDTO> dtos = interestRateParamService.getAllWithValue();
		model.addAttribute("interestRateParams", dtos);
		return "admin/interestRateParam/index";
	}

	@GetMapping("/interestRateParam/findById")
	@ResponseBody
	public Optional<InterestRateParam> findById(Integer id) {
		return interestRateParamService.findById(id);
	}

	@PostMapping("/add")
	@ResponseBody
	public Map<String, String> create(@ModelAttribute("interestRateParam") InterestRateParam interestRateParam) {
		Map<String, String> response = new HashMap<>();

		// Kiểm tra xem interestRateParamName đã tồn tại chưa
		if (interestRateParamService.existsByInterestRateParamName(interestRateParam.getInterestRateParamName())) {
			response.put("error", "Mã lãi suất đã tồn tại !");
		} else {
			// Nếu không có lỗi, thêm vào cơ sở dữ liệu
			interestRateParamService.create(interestRateParam);
		}

		return response;
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	@ResponseBody
	public Map<String, String> update(@ModelAttribute("interestRateParam") InterestRateParam interestRateParam) {
		Map<String, String> response = new HashMap<>();

		if (interestRateParamService.existsByInterestRateParamNameAndIdNot(interestRateParam.getInterestRateParamName(),
				interestRateParam.getId())) {
			response.put("error2", "Mã lãi suất đã tồn tại !");
		} else {
			// Nếu không có lỗi, thực hiện cập nhật
			interestRateParamService.update(interestRateParam);
		}

		return response;
	}

	@RequestMapping(value = "/interestRateParam/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		interestRateParamService.delete(id);
		return "redirect:/admin/interestRateParam";
	}

	@GetMapping("/export-to-excel")
	public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date(0));

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=interestRateParam" + ".xlsx"; // currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<InterestRateParam> list = interestRateParamService.getTheList();
		ExcelGenerator generator = new ExcelGenerator(list);
		generator.generateExcelFile(response);
	}

}
