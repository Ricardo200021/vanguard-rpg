package vanguardMain;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.print.attribute.standard.Media;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import javafx.scene.media.MediaPlayer;
import vanguardTxt.EscolhaPj;
import vanguardTxt.Introducao;
import vanguardTxt.Missao;

public class VanguardRpg extends JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
    private JPanel cardPanel;
    
    
    
    // Método construtor
    public VanguardRpg() {
    	
    	
        setTitle("Vanguard RPG");
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        add(cardPanel);
        
        // Adicionar tela inicial
        criarTelaInicial();
        
        // Mostrar introdução
        criarTelaIntroducao();
        
        // Criar menu principal
        criarMenuPrincipal();
        
        // Exibir a tela inicial
        cardLayout.show(cardPanel, "Tela Inicial");
        
        setVisible(true);
    }
    
    // Método para criar tela inicial
    private void criarTelaInicial() {
        JPanel inicialPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bgImage = new ImageIcon("res/cenarioIntro.gif");
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                
                
                
                // Adicionar título com sombra
                String titulo = "Vanguard RPG";
                Font font = loadPixelFont(55);
                g.setFont(font);
                
                // Coordenadas do título
                int x = (getWidth() - g.getFontMetrics().stringWidth(titulo)) / 2;
                int y = 200;
                
                // Desenhar sombra
                g.setColor(Color.BLACK);
                g.drawString(titulo, x + 3, y + 3);
                
                // Desenhar texto principal
                g.setColor(Color.BLACK);
                g.drawString(titulo, x, y);
            }
        };
            
       
        
        inicialPanel.setLayout(new BoxLayout(inicialPanel, BoxLayout.Y_AXIS));
        
        // Espaçador para centralizar os botões verticalmente
        inicialPanel.add(Box.createVerticalGlue());
        
        // Adicionar título com fonte pixelada
        JLabel tituloLabel = new JLabel("Vanguard RPG");
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tituloLabel.setFont(loadPixelFont(55));
        tituloLabel.setForeground(Color.GREEN);  // Ajustar a cor do texto para branco
        inicialPanel.add(tituloLabel);
        
        // Espaço entre título e botões
        inicialPanel.add(Box.createRigidArea(new Dimension(0, 150)));
        
     // Configuração comum para os botões
        Font buttonFont = loadPixelFont(20);  // Fonte dos botões
        Color buttonColor = Color.GREEN;      // Cor do texto dos botões
        Color shadowColor = Color.BLACK;      // Cor da sombra dos botões
        
        
     // Botão de entrada start
        JButton startButton = createButtonWithShadow("Start", buttonFont, buttonColor, shadowColor);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setPreferredSize(new Dimension(170, 30));  // Tamanho maior para o botão
        startButton.setMaximumSize(new Dimension(170, 30));    // Assegura que o tamanho é mantido
        startButton.addActionListener(e -> cardLayout.show(cardPanel, "Tela Introdução"));
        inicialPanel.add(startButton);
        
        // Espaçamento entre os botões
        inicialPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        
        
     // Botão de saída exit
        JButton exitButton = createButtonWithShadow("Exit", buttonFont, buttonColor, shadowColor);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setPreferredSize(new Dimension(170, 30));  // Tamanho maior para o botão
        exitButton.setMaximumSize(new Dimension(170, 30));
        exitButton.addActionListener(e -> System.exit(0));
        inicialPanel.add(exitButton);
        
        // Espaçador para centralizar os botões verticalmente
        inicialPanel.add(Box.createVerticalGlue());
        
        cardPanel.add(inicialPanel, "Tela Inicial");
    }
    
 // Método auxiliar para criar botões com sombra
    private JButton createButtonWithShadow(String text, Font font, Color textColor, Color shadowColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setFont(font);
                
             // Coordenadas do texto do botão
                FontMetrics fm = g2d.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(text)) / 2;
                int y = (getHeight() + fm.getAscent()) / 2 - 2;
                
                // Desenhar sombra
                g2d.setColor(shadowColor);
                g2d.drawString(text, x + 3, y + 3);
                
                // Desenhar texto principal
                g2d.setColor(textColor);
                g2d.drawString(text, x, y);
                
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        button.setFont(font);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
        return button;
    }
    
    private Font loadPixelFont(float size) {
        try {
            // Caminho para o arquivo da fonte
            Font pixelFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PressStart2P-Regular.ttf"));
            return pixelFont.deriveFont(size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return new Font("Arial", Font.BOLD, 40); // Fonte padrão em caso de erro
        }
    }
    
    // Método para criar tela de introdução
    private void criarTelaIntroducao() {
        JPanel introducaoPanel = new JPanel();
        introducaoPanel.setLayout(new BorderLayout());
        introducaoPanel.setLayout(new BoxLayout(introducaoPanel, BoxLayout.Y_AXIS));
        introducaoPanel.setBackground(Color.BLACK);  // Fundo preto
        
        
     // Adicionar imagem no topo
        ImageIcon introImageIcon = new ImageIcon("res/cityfuture.png");  // Substitua pelo caminho da sua imagem
        JLabel introImageLabel = new JLabel(introImageIcon);
        introImageLabel.setHorizontalAlignment(JLabel.CENTER);
        introducaoPanel.add(introImageLabel, BorderLayout.NORTH);
        
        JTextArea introducaoTextArea = new JTextArea(Introducao.getTexto());
        introducaoTextArea.setWrapStyleWord(true);
        introducaoTextArea.setLineWrap(true);
        introducaoTextArea.setEditable(false);
        introducaoTextArea.setBackground(Color.BLACK);  // Fundo preto
        introducaoTextArea.setForeground(new Color(144, 238, 144));  // Texto verde claro (light green)
        introducaoTextArea.setFont(new Font("Monospaced", Font.PLAIN, 20)); 
        introducaoPanel.add(introducaoTextArea);
        
        // Adicionar margens ao JTextArea
        introducaoTextArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Adicionar JTextArea a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(introducaoTextArea);
        introducaoPanel.add(scrollPane, BorderLayout.CENTER);
        
        JButton okButton = new JButton("OK");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.addActionListener(e -> cardLayout.show(cardPanel, "Menu Principal"));
        okButton.setFont(new Font("Monospaced", Font.PLAIN, 20));
        okButton.setForeground(new Color(144, 238, 144));
        okButton.setBackground(Color.BLACK);
        okButton.setOpaque(true);
        okButton.setBorderPainted(false);
        introducaoPanel.add(okButton);
        
        
     // Painel para centralizar o botão na parte inferior
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(okButton);
        introducaoPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        cardPanel.add(introducaoPanel, "Tela Introdução");
    }
    
    // Método para mostrar personagem
    private void mostrarPersonagem(String nome, String caminhoImg) {
        JPanel personagemPanel = new JPanel();
        personagemPanel.setLayout(new BoxLayout(personagemPanel, BoxLayout.Y_AXIS));
        personagemPanel.setBackground(Color.BLACK);
        
        Font menuFont = new Font("Monospaced", Font.PLAIN, 22);
        Color textColor = new Color(144, 238, 144); // Verde claro (light green)
        
        JLabel personagemLabel = new JLabel(nome);
        personagemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        personagemLabel.setFont(menuFont);
        personagemLabel.setForeground(textColor);
        personagemPanel.add(personagemLabel);
        
        ImageIcon imagemIcone = new ImageIcon(caminhoImg);
        JLabel imagemLabel = new JLabel(imagemIcone);
        imagemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        personagemPanel.add(imagemLabel);
        
        JTextArea missaoTextArea = new JTextArea(Missao.getTexto(nome));
        missaoTextArea.setWrapStyleWord(true);
        missaoTextArea.setLineWrap(true);
        missaoTextArea.setEditable(false);
        missaoTextArea.setBackground(Color.BLACK);
        missaoTextArea.setForeground(textColor);
        missaoTextArea.setFont(menuFont);
        personagemPanel.add(missaoTextArea);
        
        missaoTextArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Criação do JScrollPane para a JTextArea
        JScrollPane scrollPane = new JScrollPane(missaoTextArea);
        scrollPane.setPreferredSize(new Dimension(400, 200)); // Ajuste o tamanho conforme necessário
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        personagemPanel.add(scrollPane);
        
        JButton voltarButton = new JButton("Voltar");
        voltarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        voltarButton.addActionListener(e -> cardLayout.show(cardPanel, "Menu Principal"));
        personagemPanel.add(voltarButton);
        
        cardPanel.add(personagemPanel, nome);
        cardLayout.show(cardPanel, nome);
    }
    
    // Método para criar menu principal
    private void criarMenuPrincipal() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(Color.BLACK);
        
        // Definir fonte e cor padrão para os componentes
        Font menuFont = new Font("Monospaced", Font.PLAIN, 22);
        Color textColor = new Color(144, 238, 144); // Verde claro (light green)
        
        JLabel escolhaPersonagemLabel = new JLabel(EscolhaPj.getTexto());
        escolhaPersonagemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        escolhaPersonagemLabel.setFont(menuFont);
        escolhaPersonagemLabel.setForeground(textColor);
        menuPanel.add(escolhaPersonagemLabel);
        
        // Espaçamento entre o texto e o primeiro botão
        menuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        
        JButton ninaButton = new JButton("Nina (Líder)");
        ninaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ninaButton.setFont(menuFont);
        ninaButton.setForeground(textColor);
        ninaButton.setBackground(Color.BLACK);
        ninaButton.setOpaque(true);
        ninaButton.setBorderPainted(false);
		ninaButton.addActionListener(e -> mostrarPersonagem("Nina", "res/Nina.png"));
		menuPanel.add(ninaButton);
		
		// Espaçamento entre o texto e o primeiro botão
        menuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
		
		
		JButton cypherButton = new JButton("Cypher (Especialista em criptograpfia)");
		cypherButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		cypherButton.setFont(menuFont);
        cypherButton.setForeground(textColor);
        cypherButton.setBackground(Color.BLACK);
        cypherButton.setOpaque(true);
        cypherButton.setBorderPainted(false);
		cypherButton.addActionListener(e -> mostrarPersonagem("Cypher", "res/Cypher.png"));
		menuPanel.add(cypherButton);
		
		// Espaçamento entre o texto e o primeiro botão
        menuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
		
		
		JButton gearButton = new JButton("Gear (Engenheiro de hardware)");
		gearButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		gearButton.setFont(menuFont);
	    gearButton.setForeground(textColor);
	    gearButton.setBackground(Color.BLACK);
	    gearButton.setOpaque(true);
	    gearButton.setBorderPainted(false);
		gearButton.addActionListener(e -> mostrarPersonagem("Gear", "res/Gear.png"));
		menuPanel.add(gearButton);
		
		// Espaçamento entre o texto e o primeiro botão
        menuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
		
		JButton shadowButton = new JButton("Shadow (Espiã de campo)");
		shadowButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		shadowButton.setFont(menuFont);
        shadowButton.setForeground(textColor);
        shadowButton.setBackground(Color.BLACK);
        shadowButton.setOpaque(true);
        shadowButton.setBorderPainted(false);
		shadowButton.addActionListener(e -> mostrarPersonagem("Shadow", "res/Shadow.png"));
		menuPanel.add(shadowButton);
		
		// Espaçamento entre o texto e o primeiro botão
        menuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
		
		JButton phantomButton = new JButton("Phantom (Hacker furtivo)");
		phantomButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		phantomButton.setFont(menuFont);
        phantomButton.setForeground(textColor);
        phantomButton.setBackground(Color.BLACK);
        phantomButton.setOpaque(true);
        phantomButton.setBorderPainted(false);
		phantomButton.addActionListener(e -> mostrarPersonagem("Phantom", "res/Phantom.png"));
		menuPanel.add(phantomButton);
		
		// Espaçamento entre o texto e o primeiro botão
        menuPanel.add(Box.createRigidArea(new Dimension(0, 75)));
		
		JButton voltarButton = new JButton("Voltar para tela inicial");
		voltarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		voltarButton.addActionListener(e -> cardLayout.show(cardPanel, "Tela Inicial"));
		menuPanel.add(voltarButton);
		
		cardPanel.add(menuPanel, "Menu Principal");
		cardLayout.show(cardPanel, "Menu Principal");
	}
	
	
	

	public static void main(String[] args) {
		
		 SwingUtilities.invokeLater(VanguardRpg::new);

	}

}