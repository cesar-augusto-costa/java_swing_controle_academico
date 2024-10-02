package prof.ArrayInterface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.io.File;

public class CadastroAlunos extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldNome;
    private JTextField textFieldMatricula;
    private JTextField textFieldCurso;
    private JTextField textFieldDataNascimento;
    private JTextField textFieldConsultaMatricula; // Campo de consulta por matrícula
    private JLabel lblResultado;

    private JRadioButton rdbtnAtivo;
    private JRadioButton rdbtnInativo;
    private ButtonGroup group; // Declaração do ButtonGroup aqui

    // Listas para armazenar os dados dos alunos (somente para armazenamento temporário na execução)
    private ArrayList<String> listaNomes = new ArrayList<>();
    private ArrayList<String> listaMatriculas = new ArrayList<>();
    private ArrayList<String> listaDatasNascimento = new ArrayList<>();
    private ArrayList<String> listaCursos = new ArrayList<>();
    private ArrayList<String> listaStatus = new ArrayList<>();

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

    //metodo construtor
    public CadastroAlunos() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 32, 46, 14);
        contentPane.add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(70, 29, 150, 20);
        contentPane.add(textFieldNome);
        textFieldNome.setColumns(10);

        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(10, 73, 60, 14);
        contentPane.add(lblMatricula);

        textFieldMatricula = new JTextField();
        textFieldMatricula.setBounds(70, 70, 150, 20);
        contentPane.add(textFieldMatricula);
        textFieldMatricula.setColumns(10);

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(10, 114, 46, 14);
        contentPane.add(lblCurso);

        textFieldCurso = new JTextField();
        textFieldCurso.setBounds(70, 111, 150, 20);
        contentPane.add(textFieldCurso);
        textFieldCurso.setColumns(10);

        JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
        lblDataNascimento.setBounds(10, 155, 120, 14);
        contentPane.add(lblDataNascimento);

        textFieldDataNascimento = new JTextField();
        textFieldDataNascimento.setBounds(130, 152, 100, 20);
        contentPane.add(textFieldDataNascimento);
        textFieldDataNascimento.setColumns(10);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(10, 190, 46, 14);
        contentPane.add(lblStatus);

        rdbtnAtivo = new JRadioButton("Ativo");
        rdbtnAtivo.setBounds(70, 186, 109, 23);
        contentPane.add(rdbtnAtivo);

        rdbtnInativo = new JRadioButton("Inativo");
        rdbtnInativo.setBounds(70, 212, 109, 23);
        contentPane.add(rdbtnInativo);

        // Inicializando o ButtonGroup fora do construtor
        group = new ButtonGroup();
        group.add(rdbtnAtivo);
        group.add(rdbtnInativo);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });
        btnCadastrar.setBounds(113, 250, 110, 23);
        contentPane.add(btnCadastrar);

        JButton btnExibirLista = new JButton("Exibir Alunos");
        btnExibirLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirListaAlunos();
            }
        });
        btnExibirLista.setBounds(234, 250, 150, 23);
        contentPane.add(btnExibirLista);
        
        

        lblResultado = new JLabel("");
        lblResultado.setBounds(10, 290, 300, 14);
        contentPane.add(lblResultado);

        // Campo para consulta por matrícula
        JLabel lblConsultaMatricula = new JLabel("Consultar por Matrícula:");
        lblConsultaMatricula.setBounds(10, 320, 150, 14);
        contentPane.add(lblConsultaMatricula);

        textFieldConsultaMatricula = new JTextField();
        textFieldConsultaMatricula.setBounds(160, 317, 150, 20);
        contentPane.add(textFieldConsultaMatricula);
        textFieldConsultaMatricula.setColumns(10);

        // Botão de Consulta
        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarAlunoArquivo();
            }
        });
        btnConsultar.setBounds(320, 316, 100, 23);
        contentPane.add(btnConsultar);
    }

    // Método Cadastrar Aluno
    private void cadastrarAluno() {
        try {
            String nome = textFieldNome.getText();
            String matricula = textFieldMatricula.getText();
            String curso = textFieldCurso.getText();
            String dataNascimento = textFieldDataNascimento.getText();
            String status;

            if (nome.isEmpty()) {
                lblResultado.setText("Erro: Campo 'Nome' está vazio.");
                return;
            }

            if (matricula.isEmpty()) {
                lblResultado.setText("Erro: Campo 'Matrícula' está vazio.");
                return;
            }

            if (curso.isEmpty()) {
                lblResultado.setText("Erro: Campo 'Curso' está vazio.");
                return;
            }

            if (dataNascimento.isEmpty()) {
                lblResultado.setText("Erro: Campo 'Data de Nascimento' está vazio.");
                return;
            }

            if (rdbtnAtivo.isSelected()) {
                status = "Ativo";
            } else if (rdbtnInativo.isSelected()) {
                status = "Inativo";
            } else {
                lblResultado.setText("Erro: Selecione o status do aluno.");
                return;
            }

            listaNomes.add(nome);
            listaMatriculas.add(matricula);
            listaDatasNascimento.add(dataNascimento);
            listaCursos.add(curso);
            listaStatus.add(status);

            lblResultado.setText("Aluno " + nome + " cadastrado com sucesso!");

            // Salvar os dados no arquivo
            salvarEmArquivo(nome, matricula, dataNascimento, curso, status);

            // Limpar os campos
            textFieldNome.setText("");
            textFieldMatricula.setText("");
            textFieldCurso.setText("");
            textFieldDataNascimento.setText("");
            // Limpar seleção de status
            group.clearSelection();

        } catch (Exception ex) {
            lblResultado.setText("Erro ao cadastrar o aluno.");
            ex.printStackTrace();
        }
    }

    private void salvarEmArquivo(String nome, String matricula, String dataNascimento, String curso, String status) {
        try (FileWriter writer = new FileWriter("alunos.txt", true)) { 
            writer.write("Nome: " + nome + "\n");
            writer.write("Matrícula: " + matricula + "\n");
            writer.write("Data de Nascimento: " + dataNascimento + "\n");
            writer.write("Curso: " + curso + "\n");
            writer.write("Status: " + status + "\n");
            writer.write("------------------------------\n");

            File file = new File("alunos.txt");
            System.out.println("Arquivo salvo em: " + file.getAbsolutePath());

        } catch (IOException e) {
            lblResultado.setText("Erro ao salvar os dados no arquivo.");
            e.printStackTrace();
        }
    }

    // Método Exibir Alunos
    private void exibirListaAlunos() {
        System.out.println("Lista de Alunos Cadastrados:");
        for (int i = 0; i < listaNomes.size(); i++) {
            System.out.println("Aluno " + (i + 1) + ":");
            System.out.println("Nome: " + listaNomes.get(i));
            System.out.println("Matrícula: " + listaMatriculas.get(i));
            System.out.println("Data de Nascimento: " + listaDatasNascimento.get(i));
            System.out.println("Curso: " + listaCursos.get(i));
            System.out.println("Status: " + listaStatus.get(i));
            System.out.println("--------------------------");
        }
    }

    // Método para consultar um aluno no arquivo com base na matrícula
    private void consultarAlunoArquivo() {
        String matriculaConsulta = textFieldConsultaMatricula.getText();
        if (matriculaConsulta.isEmpty()) {
            lblResultado.setText("Erro: Matrícula não informada.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("alunos.txt"))) {
            String line;
            boolean alunoEncontrado = false;
            StringBuilder alunoInfo = new StringBuilder();
            String nome = "", dataNascimento = "", curso = "", status = "";

            while ((line = reader.readLine()) != null) {
                // Verifica se a linha contém a matrícula
                if (line.contains("Matrícula: " + matriculaConsulta)) {
                    alunoEncontrado = true;
                    // Pega as informações anteriores e posteriores à matrícula
                    alunoInfo.append("Nome: ").append(nome).append("\n");
                    alunoInfo.append(line).append("\n");  // Matrícula
                    alunoInfo.append("Data de Nascimento: ").append(dataNascimento).append("\n");
                    alunoInfo.append("Curso: ").append(curso).append("\n");
                    alunoInfo.append("Status: ").append(status).append("\n");
                    break;
                }
                // Atualiza as variáveis com os dados lidos, assumindo que as linhas estão na sequência correta
                if (line.contains("Nome: ")) {
                    nome = line.substring(6); // Pegando o nome após "Nome: "
                } else if (line.contains("Data de Nascimento: ")) {
                    dataNascimento = line.substring(20); // Pegando data de nascimento após "Data de Nascimento: "
                } else if (line.contains("Curso: ")) {
                    curso = line.substring(7); // Pegando curso após "Curso: "
                } else if (line.contains("Status: ")) {
                    status = line.substring(8); // Pegando status após "Status: "
                }
            }

            if (alunoEncontrado) {
                lblResultado.setText("Aluno encontrado.");
                System.out.println(alunoInfo.toString());  // Exibe as informações do aluno no console
            } else {
                lblResultado.setText("Aluno não encontrado.");
            }

        } catch (IOException e) {
            lblResultado.setText("Erro ao consultar o arquivo.");
            e.printStackTrace();
        }
    }
}
