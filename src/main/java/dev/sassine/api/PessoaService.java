package dev.sassine.api;

public class PessoaService {

    Result<Error, Pessoa> buscarPessoaNaoEncontrado(String nome) {
        return new Result.Failure<>(
            new Error.UserNotFound(nome)
        );
    }
    
    Result<Error, Pessoa> buscarPessoaSucesso(String nome) {
    	 int min = 1;
         int max = 100;
        return new Result.Success<>(new Pessoa(nome,(int) (Math.random()*(max-min)) + min));
    }
}