package dev.app;

import java.awt.EventQueue;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dev.view.CadastroAlunos;
import dev.view.CadastroProfessores;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Classe que representa o Menu Principal da aplicação de Sistema de Gestão.
 * Contém opções para acessar as telas de cadastro de alunos e professores.
 */
public class MenuPrincipal extends JFrame {

    private JPanel contentPane;
    private Point initialLocation;

    /**
     * Método principal que inicia a aplicação.
     * 
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MenuPrincipal frame = new MenuPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Construtor da classe MenuPrincipal.
     * Inicializa os componentes gráficos e configura a interface da janela.
     */
    public MenuPrincipal() {
        setTitle("Menu Principal");

        // Define a ação ao fechar a janela para encerrar o programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define as dimensões da janela
        setBounds(100, 100, 400, 250);

        // Centraliza a janela na tela
        setLocationRelativeTo(null);

        // Impede o redimensionamento da janela
        setResizable(false);

        // Armazena a posição inicial da janela
        initialLocation = getLocation();

        // Adiciona um ouvinte para manter a janela fixa na posição original
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                setLocation(initialLocation);
            }
        });

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("Sistema de Gestão");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));

        // Configura botão para cadastro de alunos
        JButton btnCadastroAluno = new JButton("Cadastrar Aluno");
        btnCadastroAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCadastroAluno.setMnemonic('A'); // Atalho Alt + A
        btnCadastroAluno.addActionListener(e -> abrirTelaCadastroAlunos());

        // Configura botão para cadastro de professores
        JButton btnCadastroProfessor = new JButton("Cadastrar Professor");
        btnCadastroProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCadastroProfessor.setMnemonic('P'); // Atalho Alt + P
        btnCadastroProfessor.addActionListener(e -> abrirTelaCadastroProfessores());

        // Define o layout do painel
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.CENTER)
                .addComponent(lblTitulo)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(btnCadastroAluno, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                    .addGap(20)
                    .addComponent(btnCadastroProfessor, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createSequentialGroup()
                .addGap(20)
                .addComponent(lblTitulo)
                .addGap(30)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    .addComponent(btnCadastroAluno, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastroProfessor, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        );
        contentPane.setLayout(gl_contentPane);
    }

    /**
     * Abre a tela de cadastro de alunos.
     */
    private void abrirTelaCadastroAlunos() {
        CadastroAlunos frameAluno = new CadastroAlunos();
        frameAluno.setVisible(true);
    }

    /**
     * Abre a tela de cadastro de professores.
     */
    private void abrirTelaCadastroProfessores() {
        CadastroProfessores frameProfessor = new CadastroProfessores();
        frameProfessor.setVisible(true);
    }
}
