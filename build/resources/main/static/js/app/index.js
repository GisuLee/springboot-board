var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
         $('#btn-test').on('click', function () {
            _this.test();
        });
    },
   test : function (){

           var temp =$('#point').val();
           var ojb = JSON.parse(temp);

           alert(JSON.stringify(data));
           $.ajax({
               type: 'POST',
               url: '/test',
               dataType: 'json',
               contentType:'application/json; charset=utf-8',
               data: JSON.stringify(ojb)
           }).done(function() {
               alert('글이 등록되었습니다.');
               window.location.href = '/';
           }).fail(function (error) {
               alert(JSON.stringify(error));
           });
       },

    save : function () {

        var userString = $('#user').val();
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val(),
            writer : JSON.parse(userString)
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var userString = $('#user').val();
        var data = {
            title: $('#title').val(),
            content: $('#content').val(),
            sessionUser: JSON.parse(userString)
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();
        var userString = $('#user').val();
        var data = JSON.parse(userString);
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();