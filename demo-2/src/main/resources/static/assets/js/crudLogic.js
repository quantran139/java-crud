/**
 * 
 */


 $('document').ready(function () {
 	
 	$('#createModalForm').submit(function(event) {
        event.preventDefault(); // Ngăn chặn form được submit mặc định
        
        // Lấy dữ liệu từ form
        var formData = $(this).serialize();
        
        // Gửi yêu cầu AJAX để tạo mới
        $.ajax({
            type: "POST",
            url: "/admin/add",
            data: formData,
            success: function(response) {
                if (response.error) {
                    // Hiển thị thông báo lỗi trong modal
                    $('#error-message').text(response.error).show();
                    $('#interestRateParamName').addClass('is-invalid');
                    $('#createModal').modal('show');
                } else {
                    // Nếu không có lỗi, làm gì đó khác (ví dụ: reload trang)
                    location.reload();
                }
            },
            error: function(xhr, status, error) {
                // Xử lý lỗi nếu có
                console.log("Error:", error);
            }
        });
    });
    
 	
 	
 	
 	var selectedRow;

    // Sự kiện khi nhấn vào một hàng trong bảng
    $('#example2 tbody').on('click', 'tr', function () {
        // Đánh dấu hàng được chọn và lưu lại
        if ($(this).hasClass('selected')) {
        // Nếu đã được chọn, loại bỏ lớp 'selected' và đặt lại biến selectedRow thành null
        $(this).removeClass('selected');
        selectedRow = null;
    } else {
        // Nếu chưa được chọn, đánh dấu hàng được chọn và lưu lại
        if (selectedRow) {
            selectedRow.removeClass('selected');
        }
        selectedRow = $(this);
        selectedRow.addClass('selected');
    }
    });

    // Sự kiện khi nhấn vào nút "Sửa"
    $('.editButton').on('click', function () {
        // Kiểm tra xem đã chọn hàng chưa
        if (selectedRow) {
            // Lấy dữ liệu từ hàng được chọn
            var id = selectedRow.find('td:nth-child(2)').text();
            var name = selectedRow.find('td:nth-child(3)').text();
            var status = selectedRow.find('td:nth-child(4)').text() === "Sử dụng" ? "1" : "0";
            var note = selectedRow.find('td:nth-child(5)').text();

            // Đổ dữ liệu vào modal
            $('#idEdit').val(id);
            $('#interestRateParamNameEdit').val(name);
            $('#interestRateParamStatusEdit').val(status);
            $('#interestRateParamNoteEdit').val(note);

            // Hiển thị modal
            $('#updateModal').modal();
        } else {
            // Nếu không chọn hàng, hiển thị modal thông báo
            $('#selectRowModal').modal();
        }
    });
		
     $('#updateModalForm').submit(function(event) {
        event.preventDefault(); // Ngăn chặn form được submit mặc định
        	
        // Lấy dữ liệu từ form
        var formData = $(this).serialize();
        var updateId;
        updateId = selectedRow.find('td:nth-child(2)').text();
        
        // Gửi yêu cầu AJAX để tạo mới
   
	        $.ajax({
	            type: "PUT",
	            url: '/admin/update?id=' + updateId,
	            data: formData,
	            success: function(response) {
	                if (response.error2) {
	                    // Hiển thị thông báo lỗi trong modal
	                    $('#update-error-message').text(response.error2).show();
	                    $('#interestRateParamNameEdit').addClass('is-invalid');
	                    $('#updateModal').modal('show');
	                } else {
	                    // Nếu không có lỗi, làm gì đó khác (ví dụ: reload trang)
	                    location.reload();
	                }
	            },
	            error: function(xhr, status, error) {
	                // Xử lý lỗi nếu có
	                console.log("Error:", error2);
	            }
	        });
        
    });       
            
	$('.deleteButton').on('click',function(){
		 var deleteId;
		 
		 if (selectedRow) {
			
			deleteId = selectedRow.find('td:nth-child(2)').text();
			// Hiển thị modal xác nhận xóa
            $('#deleteModal').modal('show');
            
           $('#confirmDeleteButton').on('click', function () {
           
           $.ajax({
            url: '/admin/interestRateParam/delete?id=' + deleteId, // Đường dẫn của API xóa hàng
            type: 'DELETE',
            success: function (response) {
                // Xóa hàng khỏi giao diện người dùng nếu xóa thành công
                $('[data-id="' + id + '"]').closest('tr').remove();
                // Đóng modal
                $('#confirmDeleteModal').modal('hide');
            },
            error: function (xhr, status, error) {
                // Xử lý lỗi (ví dụ: hiển thị thông báo lỗi)
                
            }
        });
        });
		   
			} else {
            // Nếu không chọn hàng, hiển thị modal thông báo
            $('#selectRowModal').modal();
        }
        
        
	
	
		

	});
 	
 	
 
});