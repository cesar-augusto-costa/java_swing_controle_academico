package dev.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CadastroProfessores extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldNome;
    private JTextField textFieldID;
    private JTextField textFieldDepartamento;
    private JTextField textFieldDisciplinas;

    private ArrayList<String> listaNomes = new ArrayList<>();
    private ArrayList<String> listaIDs = new ArrayList<>();
    private ArrayList<String> listaDepartamentos = new ArrayList<>();
    private ArrayList<String> listaDisciplinas = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastroProfessores frame = new CadastroProfessores();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CadastroProfessores() {
        setTitle("Cadastro de Professores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 32, 100, 14);
        contentPane.add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(120, 29, 150, 20);
        contentPane.add(textFieldNome);
        textFieldNome.setColumns(10);

        JLabel lblID = new JLabel("ID:");
        lblID.setBounds(10, 73, 100, 14);
        contentPane.add(lblID);

        textFieldID = new JTextField();
        textFieldID.setBounds(120, 70, 150, 20);
        contentPane.add(textFieldID);
        textFieldID.setColumns(10);

        JLabel lblDepartamento = new JLabel("Departamento:");
        lblDepartamento.setBounds(10, 114, 100, 14);
        contentPane.add(lblDepartamento);

        textFieldDepartamento = new JTextField();
        textFieldDepartamento.setBounds(120, 111, 150, 20);
        contentPane.add(textFieldDepartamento);
        textFieldDepartamento.setColumns(10);

        JLabel lblDisciplinas = new JLabel("Disciplinas:");
        lblDisciplinas.setBounds(10, 155, 100, 14);
        contentPane.add(lblDisciplinas);

        textFieldDisciplinas = new JTextField();
        textFieldDisciplinas.setBounds(120, 152, 150, 20);
        contentPane.add(textFieldDisciplinas);
        textFieldDisciplinas.setColumns(10);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarProfessor();
            }
        });
        btnCadastrar.setBounds(113, 185, 110, 23);
        contentPane.add(btnCadastrar);

        JButton btnExibirLista = new JButton("Exibir Professores");
        btnExibirLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirListaProfessores();
            }
        });
        btnExibirLista.setBounds(234, 185, 150, 23);
        contentPane.add(btnExibirLista);
    }

    private void cadastrarProfessor() {
        try {
            String nome = textFieldNome.getText();
            String id = textFieldID.getText();
            String departamento = textFieldDepartamento.getText();
            String disciplinas = textFieldDisciplinas.getText();

            // Validações
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Erro: Campo 'Nome' está vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Erro: Campo 'ID' está vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (departamento.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Erro: Campo 'Departamento' está vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (disciplinas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Erro: Campo 'Disciplinas' está vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Adicionar informações às listas
            listaNomes.add(nome);
            listaIDs.add(id);
            listaDepartamentos.add(departamento);
            listaDisciplinas.add(disciplinas);

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Professor " + nome + " cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            // Limpar campos após cadastro
            textFieldNome.setText("");
            textFieldID.setText("");
            textFieldDepartamento.setText("");
            textFieldDisciplinas.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar o professor.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exibirListaProfessores() {
        if (listaNomes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum professor cadastrado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Montar a lista de professores
        StringBuilder listaProfessores = new StringBuilder("Lista de Professores Cadastrados:\n");
        for (int i = 0; i < listaNomes.size(); i++) {
            listaProfessores.append("Professor ").append(i + 1).append(":\n");
            listaProfessores.append("Nome: ").append(listaNomes.get(i)).append("\n");
            listaProfessores.append("ID: ").append(listaIDs.get(i)).append("\n");
            listaProfessores.append("Departamento: ").append(listaDepartamentos.get(i)).append("\n");
            listaProfessores.append("Disciplinas: ").append(listaDisciplinas.get(i)).append("\n");
            listaProfessores.append("--------------------------\n");
        }

        // Exibir a lista em uma janela de diálogo
        JOptionPane.showMessageDialog(this, listaProfessores.toString(), "Lista de Professores", JOptionPane.INFORMATION_MESSAGE);
    }
}
