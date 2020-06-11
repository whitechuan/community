function post() {
    let questionId = $("#question_id").val();
    let content = $("#comment-content").val();
    $.ajax({
        type:"post",
        url :"/comment",
        contentType:"application/json",
        data:JSON.stringify({
            "parentId":questionId,
            "content":content,
            "type":1
        }),
        success: function (data) {
            if (data.code == 200){
                $("#comment_section").hide();
                console.log("jinuo");
            }else {
                console.log(data);
                if (data.code == 2003){
                    let isAccepted = confirm(data.mesage);
                    if (isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=e435398193e486367dfc&redirect_uri=http://localhost:8081/callback&scope=user&state=1");
                        window.localStorage.setItem("closable" , true);
                    }
                }else {
                    alert(data.mesage);
                }
            }
        },
        dataType: "json"
    });


}