function Facelogin() {
    setTimeout(function () {
        img = getFace();
        FaceMatch();
        $.ajax({
            type:"post",
            url:"http://localhost:8080/user/login",//后台接口
            data:{
                "imgStr":img,
                "imgType":"BASE64"
            },
            dataType:"json",
            success:function (data) {
                console.log(data);
                var start = data["start"]
                if(start == true){
                	alert("用户id:"+data["userId"]+"登录"+data["msg"])

                }
                else{
                	console.log(data["errorMsg"])
                    Facelogin();
                }
            },
            error:function () {
                alert("连接服务器失败")
            },
            async:true
        })
    },500);
}
function getsocket() {

    $.ajax({
            type: "post",
            url:"http://localhost:8080/socket/startal",
            data:{
                "args":"我嫩爹",
            },
            success:function (ans) {
                alert(ans);
            },
            error:function () {
                alert("发生错误")

            }
        }

    )
}
function FaceMatch() {
    img = getFace();
    var v = $("#Imgstr").val();
    var img1 = {
        "imgStr":img,
        "imgType":"BASE64"
    };
    img1 = JSON.stringify(img1);
    var img2 = {
        "imgStr":v,
        "imgType":"BASE64"
    }
    img2 = JSON.stringify(img2);

    var data = { }
    data.img1 = img1;
    data.img2 = img2;
    $.ajax({
        type:"post",
        url:"http://localhost:8080/user/match",//后台接口
        data:JSON.stringify(data),
        dataType:"json",
        contentType: 'application/json; charset=UTF-8',
        success:function (data) {
            console.log(data["start"]);
            if(data["start"]==true){
                var tosecond = document.getElementById('tosecond');
                tosecond.click();
            }
        },
        error:function (e) {

        },
        async:true
    })
}

