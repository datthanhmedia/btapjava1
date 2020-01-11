/**
 * 
 */
function updateorder(id){
	var orderstatus = "order-orderstatus-" + id;
	var updatebutton = "update-" + id;
	
	var updatestatus = document.getElementById('orderstatus');
	var update = document.getElementById(updatebutton);
	updatestatus.innerHTML = '<select name="orderstatus" required><option value="Chưa Làm">Chưa Làm</option><option value="Đang Làm">Đang Làm</option><option value="Đã Hoàn Thành">Đã Hoàn Thành</option></select></td>';
	updatebutton.innerHTML = 'Update';
}