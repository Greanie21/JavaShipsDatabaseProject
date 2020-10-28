
import BAL.CruzadorBAL;
import BAL.NavioBAL;
import BAL.NavioDeGuerraBAL;
import BAL.NavioMercanteBAL;
import BAL.PortaAvioesBAL;
import VO.CruzadorVO;
import VO.NavioDeGuerraVO;
import VO.NavioMercanteVO;
import VO.NavioVO;
import VO.PortaAvioesVO;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Principal {

    static String msgNavios = "1-Cruzador.\n2-Porta Aviões.\n3-Navio De Guerra.\n4-Navio Mercante.\n5-Navio.";

    public static void main(String[] args) throws Exception {
        boolean isNotOver = true;
        String msg, choice;

        while (isNotOver) {
            msg = "1-Inserir.\n2-Olhar tabela.\n3-Editar.\n4-Excluir.\n5-Parar o Programa.";
            choice = JOptionPane.showInputDialog(null, msg);

            if (choice == null) {
                return;
            }

            switch (choice) {
                case "1":
                    Creates();
                    break;
                case "2":
                    Reads();
                    break;
                case "3":
                    Updates();
                    break;
                case "4":
                    Delets();
                    break;
                default:
                    isNotOver = false;
                    break;
            }
            System.out.print("\n");
        }
    }

    static void Creates() throws Exception {
        String msg, choice;
        msg = msgNavios;
        choice = JOptionPane.showInputDialog(null, msg);

        switch (choice) {
            case "1":
                InsertCruzador();
                break;
            case "2":
                InsertPortaAvioes();
                break;
            case "3":
                InsertNavioDeGuerra();
                break;
            case "4":
                InsertNavioMercante();
                break;
            case "5":
                InsertNavio();
                break;
        }
    }

    static void Reads() throws SQLException, Exception {
        String msg, choice;
        boolean readAll = true;
        msg = "Qual tipo de navio tu quer ver?\n" + msgNavios;
        choice = JOptionPane.showInputDialog(null, msg);

        msg = "Qual navio esta procurando?\n1-Buscar um navio especifico \n2-Olhar todos";
        if ("1".equals(JOptionPane.showInputDialog(null, msg))) {
            readAll = false;
        }

        switch (choice) {
            case "1":
                if (readAll) {
                    ReadCruzadorAll();
                } else {
                    msg = "Digite o id do navio que deseja ver";
                    choice = JOptionPane.showInputDialog(null, msg);

                    ReadCruzadorById(Integer.parseInt(choice));
                }
                break;
            case "2":
                if (readAll) {
                    ReadPortaAvioesAll();
                } else {
                    msg = "Digite o id do navio que deseja ver";
                    choice = JOptionPane.showInputDialog(null, msg);

                    ReadPortaAvioesById(Integer.parseInt(choice));
                }
                break;
            case "3":
                if (readAll) {
                    ReadNavioDeGuerraAll();
                } else {
                    msg = "Digite o id do navio que deseja ver";
                    choice = JOptionPane.showInputDialog(null, msg);

                    ReadNavioDeGuerraById(Integer.parseInt(choice));
                }
                break;
            case "4":
                if (readAll) {
                    ReadNavioMercanteAll();
                } else {
                    msg = "Digite o id do navio que deseja ver";
                    choice = JOptionPane.showInputDialog(null, msg);

                    ReadNavioMercanteById(Integer.parseInt(choice));
                }
                break;
            case "5":
                if (readAll) {
                    ReadNavioAll();
                } else {
                    msg = "Digite o id do navio que deseja ver";
                    choice = JOptionPane.showInputDialog(null, msg);

                    ReadNavioById(Integer.parseInt(choice));
                }
                break;

        }
    }

    static void Updates() throws Exception {
        String msg, choice;
        msg = "Qual tipo de navio tu quer editar?\n" + msgNavios;
        choice = JOptionPane.showInputDialog(null, msg);

        switch (choice) {
            case "1":
                EditCruzador();
                break;
            case "2":
                EditPortaAvioes();
                break;
            case "3":
                EditNavioDeGuerra();
                break;
            case "4":
                EditNavioMercante();
                break;
            case "5":
                EditNavio();
                break;
        }
    }

    static void Delets() throws SQLException, Exception {
        String msg, choice;
        msg = "Qual tipo de navio tu quer Deletar?\n" + msgNavios;
        choice = JOptionPane.showInputDialog(null, msg);

        switch (choice) {
            case "1":
                DeleteCruzador();
                break;
            case "2":
                DeletePortaAvioes();
                break;
            case "3":
                DeleteNavioDeGuerra();
                break;
            case "4":
                DeleteNavioMercante();
                break;
            case "5":
                DeleteNavio();
                break;
        }
    }

    static void InsertCruzador() throws SQLException, Exception {
        String msg;
        msg = "Digite o nome da embarcação.";
        String nome = JOptionPane.showInputDialog(null, msg);
        msg = "Digite o numero de tripulantes.";
        int tripulantes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero da blindagem.";
        int blindagem = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero do ataque.";
        int ataque = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero de canhoes.";
        int canhoes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        CruzadorVO cruzVO = new CruzadorVO(tripulantes, nome, blindagem, ataque, canhoes);
        CruzadorBAL cruzBAL = new CruzadorBAL();

        int result = cruzBAL.Insert(cruzVO);
        int result2 = new NavioDeGuerraBAL().Insert(cruzVO, "idNavioCruzador");
        int result3 = new NavioBAL().Insert(cruzVO, "idNavioDeGuerra");

        if (result == 1 && result2 == 1 && result3 == 1) {
            System.out.println("Nome:" + cruzVO.getNome() + " cadastrado com sucesso");
            cruzVO.poderDeFogo();
        } else {
            System.out.println("Erro");
        }
    }

    static void InsertPortaAvioes() throws SQLException, Exception {
        String msg;
        msg = "Digite o nome da embarcação.";
        String nome = JOptionPane.showInputDialog(null, msg);
        msg = "Digite o numero de tripulantes.";
        int tripulantes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero da blindagem.";
        int blindagem = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero do ataque.";
        int ataque = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero de avioes.";
        int avioes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        PortaAvioesVO pAvioesVO = new PortaAvioesVO(tripulantes, nome, blindagem, ataque, avioes);
        PortaAvioesBAL pAvioesBAL = new PortaAvioesBAL();

        int result = pAvioesBAL.Insert(pAvioesVO);
        int result2 = new NavioDeGuerraBAL().Insert(pAvioesVO, "idNavioPortaAvioes");
        int result3 = new NavioBAL().Insert(pAvioesVO, "idNavioDeGuerra");

        if (result == 1 && result2 == 1 && result3 == 1) {
            System.out.println("Nome:" + pAvioesVO.getNome() + " cadastrado com sucesso");
            pAvioesVO.poderDeFogo();
        } else {
            System.out.println("Erro");
        }
    }

    static void InsertNavioDeGuerra() throws Exception {
        String msg;
        msg = "Digite o nome da embarcação.";
        String nome = JOptionPane.showInputDialog(null, msg);
        msg = "Digite o numero de tripulantes.";
        int tripulantes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero da blindagem.";
        int blindagem = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero do ataque.";
        int ataque = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        NavioDeGuerraVO nGuerraVO = new NavioDeGuerraVO(tripulantes, nome, blindagem, ataque);
        int result = new NavioDeGuerraBAL().Insert(nGuerraVO);
        int result2 = new NavioBAL().Insert(nGuerraVO, "idNavioDeGuerra");

        if (result == 1 && result2 == 1) {
            System.out.println("Nome:" + nGuerraVO.getNome() + " cadastrado com sucesso");
            nGuerraVO.exibirArmas();
        } else {
            System.out.println("Erro ao inserir navio");
        }
    }

    static void InsertNavioMercante() throws Exception {
        String msg;
        msg = "Digite o nome da embarcação.";
        String nome = JOptionPane.showInputDialog(null, msg);
        msg = "Digite o numero de tripulantes.";
        int tripulantes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite a capacidade de carga da embarcação.";
        double capacidadeDeCarga = Double.parseDouble(JOptionPane.showInputDialog(null, msg));
        msg = "Digite a carga atual da embarcação.";
        double carga = Double.parseDouble(JOptionPane.showInputDialog(null, msg));

        NavioMercanteVO nMercVO = new NavioMercanteVO(tripulantes, nome, capacidadeDeCarga, carga);
        NavioMercanteBAL nMercBAL = new NavioMercanteBAL();

        int result = nMercBAL.Inserir(nMercVO);
        int result2 = new NavioBAL().Insert(nMercVO, "idNavioMercante");
        if (result == 1 && result2 == 1) {
            System.out.println("Nome:" + nMercVO.getNome() + " cadastrado com sucesso");
            nMercVO.cargaTotal();
        } else {
            System.out.println("Erro ao inserir navio");
        }
    }

    static void InsertNavio() throws Exception {
        String msg;
        msg = "Digite o nome da embarcação.";
        String nome = JOptionPane.showInputDialog(null, msg);
        msg = "Digite o numero de tripulantes.";
        int tripulantes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        NavioVO navioVO = new NavioVO(tripulantes, nome);
        int result = new NavioBAL().Insert(navioVO);

        if (result == 1) {
            System.out.println("Nome:" + navioVO.getNome() + " cadastrado com sucesso");
            navioVO.ExibirInfo();
        } else {
            System.out.println("Erro");
        }
    }

    static void ReadCruzadorById(int id) throws SQLException {
        CruzadorBAL cruzBAL = new CruzadorBAL();
        ResultSet resultSet = cruzBAL.Read(id);

        PrintResultSet(resultSet);
    }

    static void ReadCruzadorAll() throws SQLException {
        CruzadorBAL cruzBAL = new CruzadorBAL();
        ResultSet resultSet = cruzBAL.Read();

        PrintResultSet(resultSet);
    }

    static void ReadPortaAvioesById(int id) throws SQLException {
        PortaAvioesBAL pAvioesBAL = new PortaAvioesBAL();
        ResultSet resultSet = pAvioesBAL.Read(id);

        PrintResultSet(resultSet);
    }

    static void ReadPortaAvioesAll() throws SQLException {
        PortaAvioesBAL pAvioesBAL = new PortaAvioesBAL();
        ResultSet resultSet = pAvioesBAL.Read();

        PrintResultSet(resultSet);
    }

    static void ReadNavioDeGuerraById(int id) throws SQLException, Exception {
        NavioDeGuerraBAL nGuerraBal = new NavioDeGuerraBAL();
        ResultSet resultSet = nGuerraBal.Read(id);

        PrintResultSet(resultSet);
    }

    static void ReadNavioDeGuerraAll() throws SQLException {
        NavioDeGuerraBAL nGuerraBal = new NavioDeGuerraBAL();
        ResultSet resultSet = nGuerraBal.Read();

        PrintResultSet(resultSet);
    }

    static void ReadNavioMercanteById(int id) throws SQLException {
        NavioMercanteBAL nMercBAL = new NavioMercanteBAL();
        ResultSet resultSet = nMercBAL.Read(id);

        PrintResultSet(resultSet);
    }

    static void ReadNavioMercanteAll() throws SQLException {
        NavioMercanteBAL nMercBAL = new NavioMercanteBAL();
        ResultSet resultSet = nMercBAL.Read();

        PrintResultSet(resultSet);
    }

    static void ReadNavioById(int id) throws SQLException {
        NavioBAL nBAL = new NavioBAL();
        ResultSet resultSet = nBAL.Read(id);

        PrintResultSet(resultSet);
    }

    static void ReadNavioAll() throws SQLException {
        NavioBAL nBAL = new NavioBAL();
        ResultSet resultSet = nBAL.Read();

        PrintResultSet(resultSet);

    }

    static void PrintResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst() == false) {
            System.out.println("Nenhum Resultado encontrado");
            return;
        }

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) {
                    System.out.print(",  ");
                }
                String columnValue = resultSet.getString(i);
                System.out.print(rsmd.getColumnName(i) + " " + columnValue);
            }
            System.out.println("");
        }
    }

    static void EditCruzador() throws SQLException, Exception {
        String msg;
        msg = "Digite o id do Navio que tu quer editar.";
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o nome da embarcação.";
        String nome = JOptionPane.showInputDialog(null, msg);
        msg = "Digite o numero de tripulantes.";
        int tripulantes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero da blindagem.";
        int blindagem = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero do ataque.";
        int ataque = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero de canhoes.";
        int canhoes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        CruzadorVO cruzVO = new CruzadorVO(tripulantes, nome, blindagem, ataque, canhoes);
        CruzadorBAL cruzBAL = new CruzadorBAL();

        int result = cruzBAL.Edit(cruzVO, id);
        int result2 = new NavioDeGuerraBAL().Edit(cruzVO, id);
        int result3 = new NavioBAL().Edit(cruzVO, id);

        if (result == 1 && result2 == 1 && result3 == 1) {
            System.out.println("Nome:" + cruzVO.getNome() + " editado com sucesso");
        } else {
            System.out.println("Erro");
        }
    }

    static void EditPortaAvioes() throws SQLException, Exception {
        String msg;
        msg = "Digite o id do Navio que tu quer editar.";
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o nome da embarcação.";
        String nome = JOptionPane.showInputDialog(null, msg);
        msg = "Digite o numero de tripulantes.";
        int tripulantes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero da blindagem.";
        int blindagem = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero do ataque.";
        int ataque = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero de avioes.";
        int avioes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        PortaAvioesVO pAvioesVO = new PortaAvioesVO(tripulantes, nome, blindagem, ataque, avioes);
        PortaAvioesBAL pAvioesBAL = new PortaAvioesBAL();

        int result = pAvioesBAL.Edit(pAvioesVO, id);
        int result2 = new NavioDeGuerraBAL().Edit(pAvioesVO, id);
        int result3 = new NavioBAL().Edit(pAvioesVO, id);

        if (result == 1 && result2 == 1 && result3 == 1) {
            System.out.println("Nome:" + pAvioesVO.getNome() + " editado com sucesso");
        } else {
            System.out.println("Erro ao tentar editar navio");
        }
    }

    static void EditNavioDeGuerra() throws Exception {
        String msg;
        msg = "Digite o id do Navio que tu quer editar.";
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o nome da embarcação.";
        String nome = JOptionPane.showInputDialog(null, msg);
        msg = "Digite o numero de tripulantes.";
        int tripulantes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero da blindagem.";
        int blindagem = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o numero do ataque.";
        int ataque = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        NavioDeGuerraVO nGuerraVO = new NavioDeGuerraVO(tripulantes, nome, blindagem, ataque);
        NavioDeGuerraBAL nGuerraBAL = new NavioDeGuerraBAL();

        int result = nGuerraBAL.Edit(nGuerraVO, id);
        int result2 = new NavioBAL().Edit(nGuerraVO, id);

        if (result == 1 && result2 == 1) {
            System.out.println("Nome:" + nGuerraVO.getNome() + " editado com sucesso");
        } else {
            System.out.println("Erro ao tentar editar navio");
        }
    }

    static void EditNavioMercante() throws Exception {
        String msg;
        msg = "Digite o id do Navio que tu quer editar.";
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o novo nome da embarcação.";
        String nome = JOptionPane.showInputDialog(null, msg);
        msg = "Digite o novo numero de tripulantes.";
        int tripulantes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite a nova capacidade de carga da embarcação.";
        double capacidadeDeCarga = Double.parseDouble(JOptionPane.showInputDialog(null, msg));
        msg = "Digite a nova carga atual da embarcação.";
        double carga = Double.parseDouble(JOptionPane.showInputDialog(null, msg));

        NavioMercanteVO nMercVO = new NavioMercanteVO(tripulantes, nome, capacidadeDeCarga, carga);
        NavioMercanteBAL nMercBAL = new NavioMercanteBAL();

        int result = nMercBAL.Edit(nMercVO, id);
        int result2 = new NavioBAL().Edit(nMercVO, id);

        if (result == 1 && result2 == 1) {
            System.out.println("Nome:" + nMercVO.getNome() + " editado com sucesso");
        } else {
            System.out.println("Erro");
        }
    }

    static void EditNavio() throws Exception {
        String msg;
        msg = "Digite o id do Navio que tu quer editar.";
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        msg = "Digite o novo nome da embarcação.";
        String nome = JOptionPane.showInputDialog(null, msg);
        msg = "Digite o novo numero de tripulantes.";
        int tripulantes = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        NavioVO nVO = new NavioVO(tripulantes, nome);
        NavioBAL nBAL = new NavioBAL();
        int result = nBAL.Edit(nVO, id);
        if (result == 1) {
            System.out.println("Nome:" + nVO.getNome() + " editado com sucesso");
        } else {
            System.out.println("Erro");
        }
    }

    static void DeleteCruzador() throws SQLException, Exception {
        String msg;
        msg = "Digite o id do Navio que tu quer deletar.";
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        NavioBAL navBal = new NavioBAL();
        NavioDeGuerraBAL navGuerraBAL = new NavioDeGuerraBAL();
        CruzadorBAL cruzBAL = new CruzadorBAL();
        ResultSet rs = cruzBAL.Read(id);
        if (rs.next() == false) {
            throw new Exception("Erro: resultset nao encontrado no delete");
        }

        int d1 = navBal.Delete(id);

        int d2 = navGuerraBAL.Delete(rs);

        int d3 = cruzBAL.Delete(rs);
        if (d1 == 1 && d2 == 1 && d3 == 1) {
            System.out.println("Navio deletado com sucesso");
        } else {
            System.out.println("Erro");
        }
    }

    static void DeletePortaAvioes() throws SQLException, Exception {
        String msg;
        msg = "Digite o id do Navio que tu quer deletar.";
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        NavioBAL navBal = new NavioBAL();
        NavioDeGuerraBAL navGuerraBAL = new NavioDeGuerraBAL();
        PortaAvioesBAL portaAvioesBAL = new PortaAvioesBAL();
        ResultSet rs = portaAvioesBAL.Read(id);
        if (rs.next() == false) {
            throw new Exception("Erro: resultset nao encontrado no delete");
        }

        int d1 = navBal.Delete(id);

        int d2 = navGuerraBAL.Delete(rs);

        int d3 = portaAvioesBAL.Delete(rs);

        if (d1 == 1 && d2 == 1 && d3 == 1) {
            System.out.println("Navio deletado com sucesso");
        } else {
            System.out.println("Erro");
        }
    }

    static void DeleteNavioDeGuerra() throws SQLException, Exception {
        String msg;
        msg = "Digite o id do Navio que tu quer deletar.";
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        NavioBAL navBal = new NavioBAL();
        NavioDeGuerraBAL navGuerraBAL = new NavioDeGuerraBAL();
        ResultSet rs = navGuerraBAL.Read(id);
        if (rs.next() == false) {
            throw new Exception("Erro: resultset nao encontrado no delete");
        }

        int d1 = navBal.Delete(id);
        int d2 = navGuerraBAL.Delete(rs);

        if (d1 == 1 && d2 == 1) {
            System.out.println("Navio deletado com sucesso");
        } else {
            System.out.println("Erro");
        }
    }

    static void DeleteNavioMercante() throws SQLException, Exception {
        String msg;
        msg = "Digite o id do Navio que tu quer deletar.";
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        NavioBAL navBal = new NavioBAL();
        NavioMercanteBAL nMercBAL = new NavioMercanteBAL();
        ResultSet rs = nMercBAL.Read(id);
        if (rs.next() == false) {
            throw new Exception("Erro: resultset nao encontrado no delete");
        }

        int result1 = navBal.Delete(id);
        int result2 = nMercBAL.Delete(rs);

        if (result1 == 1 && result2 == 1) {
            System.out.println("Navio deletado com sucesso");
        } else {
            System.out.println("Erro");
        }
    }

    static void DeleteNavio() throws SQLException {
        String msg;
        msg = "Digite o id do Navio que tu quer deletar.";
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        NavioBAL navBAL = new NavioBAL();
        int d1 = navBAL.Delete(id);

        if (d1 == 1) {
            System.out.println("Navio deletado com sucesso");
        } else {
            System.out.println("Erro");
        }
    }
}
