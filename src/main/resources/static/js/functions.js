function validateInstructions(e){
	var expressao;
	expressao = /[LlMmRr]/;
	if(expressao.test(String.fromCharCode(e.keyCode))){
		return true;
	}else{
		return false;
	}
}

function validateIdentificacao(e){
	var expressao;
	expressao = /[A-Za-z0-9]/;
	if(expressao.test(String.fromCharCode(e.keyCode))){
		return true;
	}else{
		return false;
	}
}

function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}
