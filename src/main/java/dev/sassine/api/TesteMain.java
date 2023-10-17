package dev.sassine.api;

public class TesteMain {
	
	public static void main(String[] args) {
		new RecordPatternTest().init();
		switchResults(new PessoaService().buscarPessoaNaoEncontrado("Sassine"));
		switchResults(new PessoaService().buscarPessoaSucesso("Sassine"));
	}

	private static void switchResults(Result<Error, Pessoa> result) {
		switch (result) {
		case Result.Success<?, Pessoa> success -> System.out.println("Nome da Pessoa é %s".formatted(success.value().nome()));
		case Result.Failure<Error, ?> e -> System.out.println("Error %s".formatted(e.error()));
		case null -> System.out.println("NPE!");
		}
	}
	
}
