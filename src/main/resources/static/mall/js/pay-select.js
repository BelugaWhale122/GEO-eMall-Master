//给出提醒
$('.J_bank').click(function () {
    alert('暂不支持，请耐心等候');
})

function payOrder(payType) {
    var orderNo = $("#orderNoValue").val();
    window.location.href = '/payPage?orderNo=' + orderNo + "&payType=" + payType;
}