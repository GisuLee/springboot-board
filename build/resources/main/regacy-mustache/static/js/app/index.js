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
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val(),
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
        var data = {
            title: $('#title').val(),
            content: $('#content').val(),
        };

        var postId = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+postId,
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
        var postId = $('#id').val();
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+postId,
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