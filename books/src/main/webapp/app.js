function iterator(_array, funcao){
  for(var i = 0; i < _array.length; i++){
    funcao(_array[i], i);
  }
}

$(document).ready(main);
function main(){


  $('.button-collapse').sideNav();
  $('.modal-trigger').leanModal();


  refreshBooks();
  configureForms();
  configureDeleteBooks();
  configureUpdateLinks();
}

function configureUpdateLinks(){
  $('#booklist').on('click', '.updatenode', function(e){
    e.preventDefault;
    var este = $(this);
    abrirModalUpdateLivro(este.attr('data-id'));
  });
}
