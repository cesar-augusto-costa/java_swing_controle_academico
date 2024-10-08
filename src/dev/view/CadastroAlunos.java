package dev.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

/**
 * Classe responsável pelo cadastro de alunos, permitindo a inserção de informações
 * como nome, matrícula, curso e sexo, além de exibir uma lista dos alunos cadastrados.
 */
public class CadastroAlunos extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldNome;
    private JTextField textFieldMatricula;
    private JTextField textFieldCurso;

    private ArrayList<String> listaNomes = new ArrayList<>();
    private ArrayList<String> listaMatriculas = new ArrayList<>();
    private ArrayList<String> listaCursos = new ArrayList<>();
    private ArrayList<String> listaSexos = new ArrayList<>();

    private ButtonGroup grupoSexo;

    /**
     * Método principal para iniciar a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastroAlunos frame = new CadastroAlunos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Construtor responsável por inicializar o frame de cadastro de alunos.
     * Configura a interface, centraliza a janela e impede o redimensionamento.
     */
    public CadastroAlunos() {
        setTitle("Cadastro de Alunos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Define o tamanho da janela e a impede de ser redimensionada
        setBounds(100, 100, 500, 350);
        setResizable(false);
        setLocationRelativeTo(null);  // Centraliza a janela

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));

        textFieldNome = new JTextField();
        textFieldNome.setColumns(10);

        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));

        textFieldMatricula = new JTextField();
        textFieldMatricula.setColumns(10);

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));

        textFieldCurso = new JTextField();
        textFieldCurso.setColumns(10);

        JPanel jPanelSexo = new JPanel();
        jPanelSexo.setBorder(BorderFactory.createTitledBorder("Sexo"));

        JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
        JRadioButton rdbtnFeminino = new JRadioButton("Feminino");

        grupoSexo = new ButtonGroup();
        grupoSexo.add(rdbtnMasculino);
        grupoSexo.add(rdbtnFeminino);

        jPanelSexo.add(rdbtnMasculino);
        jPanelSexo.add(rdbtnFeminino);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });

        JButton btnExibirLista = new JButton("Exibir Alunos");
        btnExibirLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirListaAlunos();
            }
        });

        // Configuração do layout
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(20)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(lblNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(lblMatricula)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textFieldMatricula, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(lblCurso)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textFieldCurso, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanelSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(btnExibirLista, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(150, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createSequentialGroup()
                .addGap(20)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblMatricula)
                    .addComponent(textFieldMatricula, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblCurso)
                    .addComponent(textFieldCurso, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addComponent(jPanelSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    .addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExibirLista, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE)
        );
        contentPane.setLayout(gl_contentPane);
    }

    /**
     * Método responsável por cadastrar um aluno e validar os campos obrigatórios.
     * Exibe mensagens de erro ou sucesso com base na validação.
     */
    private void cadastrarAluno() {
        try {
            String nome = textFieldNome.getText();
            String matricula = textFieldMatricula.getText();
            String curso = textFieldCurso.getText();
            String sexo = grupoSexo.getSelection() == null ? "" : grupoSexo.getSelection().getActionCommand();

            if (nome.isEmpty() || matricula.isEmpty() || curso.isEmpty() || sexo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Erro: Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            listaNomes.add(nome);
            listaMatriculas.add(matricula);
            listaCursos.add(curso);
            listaSexos.add(sexo);

            JOptionPane.showMessageDialog(this, "Aluno " + nome + " cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
            salvarEmArquivo(nome, matricula, dataNascimento, curso, status);
            
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar o aluno.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvarEmArquivo(String nome, String matricula, String dataNascimento, String curso, String status) {
        try (FileWriter writer = new FileWriter("alunos.txt", true)){
            writer.write("Nome: " + nome + "\n");
            writer.write("Matrícula: " + matricula + "\n");
            writer.write("Data de Nascimento: " + dataNascimento + "\n");
            writer.write("Curso: " + curso + "\n");
            writer.write("Status: " + status + "\n");
            writer.write("----------------------------------------" + "\n");

            File file = new File("alunos.txt");
            System.out.println("Arquivo salvo em: " + file.getAbsolutePath());
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar os dados no arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Método responsável por exibir a lista de alunos cadastrados.
     * Caso não haja alunos, uma mensagem informativa é exibida.
     */
    private void exibirListaAlunos() {
        if (listaNomes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder listaAlunos = new StringBuilder("Lista de Alunos Cadastrados:\n");
        for (int i = 0; i < listaNomes.size(); i++) {
            listaAlunos.append("Aluno ").append(i + 1).append(":\n");
            listaAlunos.append("Nome: ").append(listaNomes.get(i)).append("\n");
            listaAlunos.append("Matrícula: ").append(listaMatriculas.get(i)).append("\n");
            listaAlunos.append("Curso: ").append(listaCursos.get(i)).append("\n");
            listaAlunos.append("Sexo: ").append(listaSexos.get(i)).append("\n");
            listaAlunos.append("--------------------------\n");
        }

        JOptionPane.showMessageDialog(this, listaAlunos.toString(), "Lista de Alunos", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para limpar os campos de entrada após o cadastro de um aluno.
     */
    private void limparCampos() {
        textFieldNome.setText("");
        textFieldMatricula.setText("");
        textFieldCurso.setText("");
        grupoSexo.clearSelection();
    }
}
