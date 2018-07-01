package ifsp.pwe.beans;

public interface IFuncionario {
    public void obterConsumo();
    public void criarConsumo();
    public void atualizarConsumo();
    public void excluirProduto();
    public void criarProduto();
    public void atualizarCliente();
    public void obterCliente();
    public void criarCliente();
    public void criarHospedagem();
    public void atualizarHospedagem();
    public void encerrarHospedagem();
    public Proprietario login(String email, String senha);
    public void logout();
}
