package ifsp.pwe.beans;

public interface IFuncionario {
    public Proprietario login(String email, String senha);
    public void logout();
}
