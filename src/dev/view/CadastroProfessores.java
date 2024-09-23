package dev.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CadastroProfessores extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldNome;
    private JTextField textFieldID;
    private JTextField textFieldDepartamento;
    private JTextField textFieldDisciplinas;
    private JLabel lblResultado;

    
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 32, 46, 14);
        contentPane.add(lblNome);
        
        textFieldNome = new JTextField();
        textFieldNome.setBounds(120, 29, 150, 20);
        contentPane.add(textFieldNome);
        textFieldNome.setColumns(10);
        
        JLabel lblID = new JLabel("ID:");
        lblID.setBounds(10, 73, 60, 14);
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
        
        lblResultado = new JLabel("");
        lblResultado.setBounds(10, 220, 300, 14);
        contentPane.add(lblResultado);
    }

    
    private void cadastrarProfessor() {
        try {
            String nome = textFieldNome.getText();
            String id = textFieldID.getText();
            String departamento = textFieldDepartamento.getText();
            String disciplinas = textFieldDisciplinas.getText();

            if (nome.isEmpty()) {
                lblResultado.setText("Erro: Campo 'Nome' está vazio.");
                return;
            }

            if (id.isEmpty()) {
                lblResultado.setText("Erro: Campo 'ID' está vazio.");
                return;
            }

            if (departamento.isEmpty()) {
                lblResultado.setText("Erro: Campo 'Departamento' está vazio.");
                return;
            }

            if (disciplinas.isEmpty()) {
                lblResultado.setText("Erro: Campo 'Disciplinas' está vazio.");
                return;
            }

            listaNomes.add(nome);
            listaIDs.add(id);
            listaDepartamentos.add(departamento);
            listaDisciplinas.add(disciplinas);
            lblResultado.setText("Professor " + nome + " cadastrado com sucesso!");

            textFieldNome.setText("");
            textFieldID.setText("");
            textFieldDepartamento.setText("");
            textFieldDisciplinas.setText("");

        } catch (Exception ex) {
            lblResultado.setText("Erro ao cadastrar o professor.");
        }
    }

   
    private void exibirListaProfessores() {
        System.out.println("Lista de Professores Cadastrados:");
        for (int i = 0; i < listaNomes.size(); i++) {
            System.out.println("Professor " + (i + 1) + ":");
            System.out.println("Nome: " + listaNomes.get(i));
            System.out.println("ID: " + listaIDs.get(i));
            System.out.println("Departamento: " + listaDepartamentos.get(i));
            System.out.println("Disciplinas: " + listaDisciplinas.get(i));
            System.out.println("--------------------------");
        }
    }
}
