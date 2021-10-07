package factoryMethod;

import java.util.function.Function;

public class ExportadorListaProdutoMarkdown extends AbstractExportadorListaProduto {
    private static final String SEPARADOR_LN = "-";
    private static final String SEPARADOR_COL = "|";

    @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "\n";
    }

    @Override
    public String abrirLinha() {
        return "";
    }

    @Override
    public String fecharLinha() {
        return "\n";
    }

    @Override
    public String fecharLinhaTitulos() {
        StringBuilder builder = new StringBuilder();
        for (Coluna coluna : getColunas()) {
            builder.append(coluna.abrir() + "________");
        }
        builder.append("\n");
        return builder.toString();
    }

    @Override
    public void addNewColuna(Function<Produto, Object> obtemValorColuna, String titulo) {
        addColuna(new ColunaMarkdown(obtemValorColuna, titulo));
    }

}
