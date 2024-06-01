package vanguardTxt;

import javax.swing.JPanel;

public class Missao {

	public static String getTexto(String nome) {
		
		switch (nome) {
		
		case "Nina":
			return "Nina Santiago é a carismática e estratégica líder da Vanguard, um grupo de hackers rebeldes dedicados a desestabilizar a economia global controlada por um governo ditatorial. Com habilidades excepcionais em planejamento, análise de dados e liderança, ela inspira e motiva sua equipe a desafiar o sistema opressor.\r\n"
					+ "\r\n"
					+ "Fora da rede, Nina vive sob uma identidade falsa, mudando frequentemente de localização e utilizando abrigos temporários para evitar detecção. Seu cotidiano é marcado por treinamento contínuo, pesquisa e momentos de reflexão para manter a clareza mental necessária para liderar eficazmente.\r\n"
					+ "\r\n"
					+ "Motivada por um profundo senso de justiça social, Nina está disposta a sacrificar sua própria segurança pelo bem maior, lutando pela liberdade e igualdade de todos. Apesar dos desafios, ela mantém uma visão otimista sobre o futuro, acreditando que a Vanguard pode trazer uma mudança real e positiva para o mundo.";
		
		case "Cypher":
			return "Ethan \"Cypher\" Walker é o gênio criptográfico da Vanguard, especializado em decifrar códigos complexos e acessar informações confidenciais. Ele domina a criação de algoritmos criptográficos e esteganografia, garantindo comunicações seguras para sua equipe. Suas habilidades em análise forense digital e recuperação de dados são essenciais para rastrear fluxos de dados e restaurar informações cruciais.\r\n"
					+ "\r\n"
					+ "Vivendo sob identidades falsas e em locais altamente protegidos, Cypher mantém sua vida em sigilo para evitar rastreamento pelas autoridades. Dedica seu tempo à pesquisa de novas tecnologias e ao aprimoramento contínuo de suas habilidades, além de manter uma rede global de contatos na comunidade hacker.\r\n"
					+ "\r\n"
					+ "Motivado pela liberdade de informação e justiça digital, Cypher luta contra a vigilância em massa e a manipulação de dados pelo governo. Sua lealdade à Vanguard é inabalável, comprometendo-se a proteger sua equipe e a assegurar o sucesso das missões.\r\n";
			
		case "Gear":
			return "Lucas \"Gear\" Miller é o engenheiro de hardware da Vanguard, mestre em projetar, construir e modificar dispositivos eletrônicos personalizados. Suas habilidades vão desde o desenvolvimento de gadgets de espionagem até complexos sistemas de computação, além de reparo e manutenção de equipamentos críticos. Ele também é especialista em eletrônica, microcontroladores, robótica e hacking de hardware, garantindo a segurança e eficiência tecnológica da equipe.\r\n"
					+ "\r\n"
					+ "Vivendo em sigilo, Gear opera em oficinas secretas e utiliza múltiplas identidades para adquirir componentes sem levantar suspeitas. Sua rotina é dedicada à pesquisa, desenvolvimento e testes de novas tecnologias, sempre buscando soluções inovadoras. Motivado pela inovação, criatividade e um forte senso de justiça, Gear está comprometido com a luta contra a opressão, utilizando suas invenções para desmantelar o controle tecnológico do governo e devolver a liberdade ao povo.";
			
		case "Shadow":
			return "Maya \"Shadow\" Alvarado é a espiã de campo da Vanguard, especialista em disfarces, técnicas de infiltração e vigilância. Com habilidades em combate corpo a corpo e armas leves, ela neutraliza ameaças com precisão e discrição. Utilizando avançados equipamentos de vigilância e comunicação criptografada, Shadow coleta informações cruciais para as operações da Vanguard.\r\n"
					+ "\r\n"
					+ "Vivendo sob identidades falsas e mudando constantemente de localização, Shadow mantém sua verdadeira identidade em segredo. Sua rotina inclui treinamento contínuo, missões de reconhecimento e análise de inteligência. Movida por um profundo senso de justiça e lealdade à Vanguard, ela luta para expor a verdade e trazer liberdade àqueles que vivem sob regimes opressivos.";
			
		case "Phantom":
			return "Alex \"Phantom\" Novak é o mestre do pentesting na Vanguard, especialista em invadir qualquer sistema através da exploração de vulnerabilidades e uso de ferramentas de hacking avançadas. Habilidoso em engenharia social e desvio de detecção, ele pode assumir controle total de sistemas-alvo, criar malware especializado e desenvolver exploits personalizados.\r\n"
					+ "\r\n"
					+ "Vivendo em completo anonimato digital, Phantom utiliza identidades falsas e técnicas de mascaramento para operar sem ser rastreado. Sua rotina envolve pesquisa contínua, desenvolvimento de ferramentas e participação ativa em missões de invasão. Motivado pela liberdade digital e desafios intelectuais, Phantom é leal à Vanguard e comprometido com a luta contra a vigilância e opressão cibernética.";
			
		default:
			return "Personagem não encontrado.";
		}
	}

}
