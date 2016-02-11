
function refreshBooks(){
  if(!$('#booklist').length) return;
  $.ajax({
    				type: "GET",
    				url: 'api/book/all',
    				success: function(data) {
              $('#booklist').html("");
              if(data.length == 0){
                $('#booklist').html("<h3>Sem livros</h3>")
                return;
              }

              iterator(data, function(este){
                $('#booklist').append(getBookItem(este));
              });


    				},
    				error: function(response) {
              Materialize.toast('Erro ao recuperar livros!', 4000);
    					console.error("Erro ao recuperar Livros!");
              console.error(response.toString());
    				}
    });

}
function configureDeleteBooks(){
  $('#booklist').on('click', '.delete-me', function(e){
    e.preventDefault;
    var eu = $(this);
    var id = eu.attr('data-id');
    $.ajax({
    				type: "DELETE",
    				url: '/api' + id + "/delete",
    				success: function() {
              refreshBooks();
    				},
    				error: function() {

    				}

    			});
    refreshLivros();

  });
}
function configureForms(){
  $('#mandar-livro').on('click', newBook);

  $('#salvar-livro').on('click', function(e){
    e.preventDefault;
    var isto = this;
    var nome = $('#nome2').val(),
    	autor = $('#autor2').val(),
    	qtd = $('#quantidade2').val(),
      idbook = $('#livroemedicao').val();

    updateBook(idbook, {
      autor: autor,
      nome: nome,
      qtd: qtd
    }, $('#update-book'));
    refreshBooks();
  });
}



function getBookItem(obj){
 return '<li class="collection-item" id="booklist-item">'+
    '<a class="updatenode" href="#" data-id="'+ obj.id + '" class="name">' + obj.name + '</a>' +
    '<span class="author">' + obj.author + '</span>' +
    '<span class="qtd">' + obj.qtd + '</span>' +
    '<div class="deleteicon">' +
      '<a  data-id="'+ obj.id + '" class="delete-me" href="#">' +
        '<i class="material-icons tiny text-red text-darken-3">delete</i>' +
      '</a>' +
    '</div>' +
  '</li>';
}


function newBook(e) {
  e.preventDefault();
  var isto = this;
  var nome = $('#nome').val(),
  	autor = $('#autor').val(),
  	qtd = $('#quantidade').val() || 1;

  if (nome.length < 4 || autor.length < 4)
  	return Materialize.toast('Preencha o fomulario corretamente', 4000);
  $.ajax({
  	type: "POST",
  	url: '/api/book/addbook',
  	contentType: 'application/json',
  	data: JSON.stringify({
  		"author": autor,
  		"name": nome,
  		"qtd": qtd
  	}),
  	success: function() {
  		Materialize.toast('Novo livro adicionado com sucesso', 4000);
  		refreshBooks();
      $('#modal1').closeModal();
  	},
  	error: function(error) {
      var data = error.responseJSON;
      if(data.errordescription = "Livro já existe, atualizando"){
        $('#modal1').closeModal();
        refreshBooks();
        Materialize.toast('Livro já existe, atualizando..', 4000); return;

      }
      Materialize.toast('Erro ao adicionar livro', 4000);
  	},
  	processData: false,
  	dataType: 'json'
  })

}


function updateBook(idBook, campos, form){
  $.ajax({
  	type: "PUT",
  	url: "api" + idBook + "/update",
  	contentType: 'application/json',
  	data: JSON.stringify({
  		"author": campos.autor,
  		"name": campos.nome,
  		"qtd": campos.qtd
  	}),
  	success: function() {
  		Materialize.toast('Livro já existe, atualizando quantidade', 4000);
  		refreshBooks();
      $('#modal1').closeModal();
      $('#modal2').closeModal();
      form.reset();
  	},
  	error: function(p1, p2, p3) {
  		Materialize.toast('Erro ao adicionar livro', 4000);
  	},
  	processData: false,
  	dataType: 'json'
  })
}


function abrirModalUpdateLivro(idlivro){
  $.ajax({
    				type: "GET",
    				url: 'api' + idlivro + "/info",
    				success: function(data) {
              $('#nome2').val(data.name);
              $('#autor2').val(data.author);
              $('#quantidade2').val(data.qtd);
              $('#livroemedicao').val(idlivro);

              $('#modal2').openModal();

    				},
    				error: function(response) {
              Materialize.toast('Erro ao recuperar este livro!', 4000);
    				}
    });
}
