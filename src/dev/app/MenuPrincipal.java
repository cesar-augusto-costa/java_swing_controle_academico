package dev.app;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dev.view.CadastroAlunos;
import dev.view.CadastroProfessores;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MenuPrincipal extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MenuPrincipal() {
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JLabel lblTitulo = new JLabel("Sistema de Gestão");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));

        JButton btnCadastroAluno = new JButton("Cadastrar Aluno");
        btnCadastroAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCadastroAluno.setMnemonic('A'); // Atalho Alt + A
        btnCadastroAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroAlunos frameAluno = new CadastroAlunos();
                frameAluno.setVisible(true);
            }
        });

        JButton btnCadastroProfessor = new JButton("Cadastrar Professor");
        btnCadastroProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCadastroProfessor.setMnemonic('P'); // Atalho Alt + P
        btnCadastroProfessor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroProfessores frameProfessor = new CadastroProfessores();
                frameProfessor.setVisible(true);
            }
        });

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
}
