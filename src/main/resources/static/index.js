$(document).ready(function () {
   $('.js-form-btn').click(function () {
       var $form = $(this).parents('.js-form');
       $.ajax({
           type: 'post',
           url: '/api/rnd',
           data: getFormData($form),
           dataType: 'text',
           success: function (data) {
               $('.js-output').html('' + data.toString());
           }
       })
   });
});

function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}