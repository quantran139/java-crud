$(document).ready(function() {
    $('.table').DataTable( {
        // Sắp xếp theo cột đầu tiên (cột có index là 0) theo thứ tự tăng dần
        
   		 	paging: true, // Enable pagination
            searching: true, // Enable search box
            ordering: true, // Enable sorting
            lengthChange: false,
            pageLength: 25,
    } );
} );