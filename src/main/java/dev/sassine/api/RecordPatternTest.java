package dev.sassine.api;

import static java.lang.System.out;

class RecordPatternTest {

    public void init() {
        var p = new Pessoa("Sassine", 26);
        validaSeDeMaiorSwitchJDK17(p);
        validaSeDeMaiorSwitchJDK21(p);
        validaSeDeMaiorJDK17(p);
        validaSeDeMaiorJDK21(p);
    }

    static void validaSeDeMaiorSwitchJDK17(Object p) {
        switch (p) {
            case Pessoa p1 -> out.println("%s Permitido".formatted(p1.nome()));
            case null, default -> out.println("Não permitido");
        }
    }

    static void validaSeDeMaiorSwitchJDK21(Object p) {
        switch (p) {
            case Pessoa(var nome, var idade) when idade >= 18 -> out.println("%s Permitido".formatted(nome));
            case null -> out.println("Null pointer não");
            default -> out.println("Não permitido");
        }
    }

    static void validaSeDeMaiorJDK17(Object p) {
        if (p instanceof Pessoa p1 && p1.idade() >= 18) {
            out.println("%s Permitido".formatted(p1.nome()));
        } else {
            out.println("Não permitido");
        }
    }

    static void validaSeDeMaiorJDK21(Object p) {
        if (p instanceof Pessoa(var nome, var idade) && idade >= 18) {
            out.println("%s Permitido".formatted(nome));
        } else {
            out.println("Não permitido");
        }
    }

}
