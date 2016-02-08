$(document).ready(main);
function main(){

  $('.button-collapse').sideNav();
  $('.modal-trigger').leanModal();

  refreshLivros();
  configurarForms();
  configurarDelete();
}
function configurarDelete(){

  $('#booklist').on('click', '.delete-me', function(e){
    e.preventDefault;
    var eu = $(this);
    var id = eu.attr('data-id');
    $.ajax({
    				type: "DELETE",
    				url: '/api' + id,
    				success: function() {

    				},
    				error: function() {

    				}

    			});
    refreshLivros();

  });
}
function novoLivro(e) {
    			e.preventDefault();
    			var isto = this;
    			var nome = $('#nome').val(),
    				autor = $('#autor').val(),
    				qtd = $('#quantidade').val() || 1;

    			if (nome.length < 4 || autor.length < 4)
    				return alert('Preencha corretamente')
    			$.ajax({
    				type: "POST",
    				url: '/api/book',
    				contentType: 'application/json',
    				data: JSON.stringify({
    					"author": autor,
    					"name": nome,
    					"qtd": qtd
    				}),
    				success: function() {
    					console.log("DEU CERTO!!!!!1!1");
    					refreshLivros();
              $('#modal1').closeModal();

    				},
    				error: function() {
    					console.log("erro!!");
    				},
    				processData: false,
    				dataType: 'json'
    			})

    		}

function configurarForms(){
  $('#mandar-livro').on('click', novoLivro);
}

function refreshLivros(){
  if(!$('#booklist').length) return console.log('Não tem livros!');


  $.ajax({
    				type: "GET",
    				url: 'api/book',
    				success: function(data) {
              $('#booklist').html("");
              if(data.length == 0){
                $('#booklist').html("<h3>Sem livros</h3>")
                return;
              }

              iterador(data, function(este, indice){
                $('#booklist').append(getBookItem(este));
              });


    				},
    				error: function(response) {
    					console.error("Erro ao recuperar Livros!");
              console.error(response.toString());
    				}
    });

}
function iterador(_array, funcao){
  for(var i = 0; i < _array.length; i++){
    funcao(_array[i], i);

  }
}

function getBookItem(obj){
 return '<li class="collection-item" id="booklist-item">'+
    '<span class="name">' + obj.name + '</span>' +
    '<span class="author">' + obj.author + '</span>' +
    '<span class="qtd">' + obj.qtd + '</span>' +
    '<div class="deleteicon">' +
      '<a  data-id="'+ obj.id + '" class="delete-me" href="#">' +
        '<i class="material-icons tiny text-red text-darken-3">delete</i>' +
      '</a>' +
    '</div>' +
  '</li>';

}
