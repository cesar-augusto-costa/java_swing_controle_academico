package dev.app;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dev.view.CadastroAlunos;
import dev.view.CadastroProfessores;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JButton btnCadastroAluno = new JButton("Cadastrar Aluno");
        btnCadastroAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroAlunos frameAluno = new CadastroAlunos();
                frameAluno.setVisible(true);
            }
        });
        btnCadastroAluno.setBounds(10, 50, 164, 50);
        contentPane.add(btnCadastroAluno);

        
        JButton btnCadastroProfessor = new JButton("Cadastrar Professor");
        btnCadastroProfessor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroProfessores frameProfessor = new CadastroProfessores();
                frameProfessor.setVisible(true);
            }
        });
        btnCadastroProfessor.setBounds(196, 50, 178, 50);
        contentPane.add(btnCadastroProfessor);
    }
}

