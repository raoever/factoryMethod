package factoryMethod;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractExportadorListaProduto implements ExportadorListaProduto{
    private List<Coluna> colunas;

    public AbstractExportadorListaProduto() {
        colunas = new ArrayList<>();
        addNewColuna(Produto::getId, "Código");
        addNewColuna(Produto::getDescricao, "Descrição");
        addNewColuna(Produto::getPreco, "Preço");
    }

    protected void addColuna(Coluna coluna) {
        colunas.add(coluna);
    }

    @Override
    public String abrirTabela() {
        return null;
    }

    @Override
    public String fecharTabela() {
        return null;
    }

    @Override
    public String abrirLinha() {
        return null;
    }

    @Override
    public String fecharLinha() {
        return null;
    }

    @Override
    public String fecharLinhaTitulos() {
        return null;
    }

    private String abrirColuna(String valor) {
        return null;
    }

    private String fecharColuna() {
        return null;
    }

    @Override
    public final String exportar(List<Produto> listaProdutos) {
        final StringBuilder sb = new StringBuilder();
        sb.append(abrirTabela());
        sb.append(abrirLinha());
        for (Coluna coluna : colunas) {
            sb.append(coluna.exportarCabecalho());
        }
        sb.append(fecharLinha());
//        sb.append("\n");
        sb.append(fecharLinhaTitulos());
        gerarLinhasProdutos(sb, listaProdutos);

        sb.append(fecharTabela());
        return sb.toString();
    }

    private void gerarLinhasProdutos(StringBuilder sb, List<Produto> listaProdutos) {
        for (Produto produto : listaProdutos) {
            sb.append(gerarColunasLinha(produto));
        }
    }

    protected String gerarColunasLinha(Produto produto) {
        StringBuilder sb = new StringBuilder();
        sb.append(abrirLinha());
        for (Coluna coluna : colunas) {
            sb.append(coluna.exportarDado(produto));
        }
        sb.append(fecharLinha());
        return sb.toString();
    }

    protected List<Coluna> getColunas() {
        return colunas;
    }
}
