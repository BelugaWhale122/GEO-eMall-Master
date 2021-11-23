function payOrderSuccess() {
    var orderNo = $("#orderNoValue").val();
    $.ajax({
        type: 'GET',
        url: '/paySuccess?payType=1&orderNo=' + orderNo,
        success: function (result) {
            if (result.resultCode == 200) {
                window.location.href = '/orders/' + orderNo;
            } else {
                alert(result.message);
            }
        },
        error: function () {
            alert("操作失败");
        }
    });
}