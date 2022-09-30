package com.rafael.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.bookstore.domain.Categoria;
import com.rafael.bookstore.domain.Livro;
import com.rafael.bookstore.repository.CategoriaRepository;
import com.rafael.bookstore.repository.LivroRepository;

@Service
public class DBService{
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {

        Categoria cat1 = new Categoria(null, "Tecnologia", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Arquitetura", "Livros de Arquitetura");

		Livro l1 = new Livro(null, "Arquitetura Limpa: O guia do artesão para estrutura e design de software", "Robert Cecil Martin", "Tem havido muita confusão entre os termos design e\n" +
				"arquitetura ao longo dos anos. O que é design? O que é\n" +
				"arquitetura? Quais são as diferenças entre os dois?\n" +
				"Um dos objetivos deste livro é acabar com essa\n" +
				"confusão e definir, de uma vez por todas, o que são\n" +
				"design e arquitetura. Para começar, afirmo que não há\n" +
				"diferença entre os dois termos. Nenhuma diferença.", cat1);

		Livro l2 = new Livro(null, "Estruturas de dados e algoritmos com JavaScript: Escreva um código JavaScript complexo e eficaz usando a mais recente ECMAScript", "Loiane Groner", "Neste livro materializamos o conteúdo ministrado nos últimos anos na disciplina Algoritmos e Estruturas de Dados I, ofertada para os cursos de Ciência da Computação\n" +
				"e Informática Biomédica da Universidade Federal do Paraná.\n" +
				"Esta disciplina é ministrada no primeiro semestre (para os calouros) e é a primeira das cinco que cobrem o conteúdo básico de algoritmos sem o qual um curso de\n" +
				"Computação não faz sentido. As disciplinas subsequentes são:\n" +
				"• Algoritmos e Estruturas de Dados II;\n" +
				"• Algoritmos e Estruturas de Dados III;\n" +
				"• Análise de Algoritmos; e\n" +
				"• Algoritmos e Teoria dos Grafos.\n" +
				"A orientação dos colegiados dos cursos é que esta disciplina deve ter um conteúdo\n" +
				"forte em conceitos de algoritmos na qual a implementação final em uma linguagem\n" +
				"de programação é vista apenas como um mecanismo facilitador ao aprendizado dos\n" +
				"conceitos teóricos.\n" +
				"Os currículos destes cursos contêm duas disciplinas nas quais a arte da programação é explorada ao máximo. Elas são ministradas respectivamente no segundo e\n" +
				"terceiros semestres. São elas:\n" +
				"• Programação I; e\n" +
				"• Programação II.\n" +
				"Por este motivo, embora adotemos a linguagem Pascal na redação dos programas\n" +
				"feitos neste texto, este é um livro que se preocupa com algoritmos. Ele contém o\n" +
				"mínimo necessário sobre Pascal , somente o suficiente para que os estudantes possam\n" +
				"praticar a programação dos algoritmos estudados. Os estudantes são encorajados a\n" +
				"buscarem apoio na literatura e nos guias de referência disponíveis para o compilador\n" +
				"escolhido, incluindo um guia de referência básico que foi escrito pelos monitores da\n" +
				"disciplina no ano de 2009.\n", cat1);


		Livro l3 = new Livro(null, "Arte de projetar em arquitetura", "Ernst Neufert", "Conheci o Neufert quando estava pesquisando sobre arquitetura na Biblioteca Pública do Paraná, queria ver alguns livros mais técnicos para decidir se realmente era isso que eu queria para minha vida, ser uma arquiteta.\n" +
				"\n" +
				"Perguntei ao assistente qual livro ele me indicava e logo ele me disse:\n" +
				"\n" +
				"– Esse daqui é o mais procurado.\n" +
				"\n" +
				"Um baita livrão enorme, pesado, uma edição bem antiga. Levei para casa e comecei a ler no mesmo dia.\n" +
				"\n" +
				"Tinha tudo, tipos de telhado, tipos de estrutura, dimensão de vias para estacionamento, tipos de edificações. Ou seja, este livro reúne princípios, normas e representações sobre construção, instalações, distribuição dos ambientes, dimensões de edifícios, locais e mobiliário.", cat2);


		Livro l4 = new Livro(null, "Manual do Arquiteto Descalço - 2.ed", "Johan van Lengen", "A Bio-arquitetura é um conceito que une ecologia, arquitetura e urbanismo. Revela técnicas e maneiras de construção em harmonia com a natureza e os seus recursos, promovendo o equilíbrio entre o meio ambiente e o progresso, e ao mesmo tempo ajudando o homem a habitar o mundo de forma digna.\n" +
				"\n" +
				"Veja Também: Manual Online ensina como cultivar horta em casa (ou no apê)\n" +
				"\n" +
				"Nesta obra o arquiteto propõe explicações surpreendentes sobre contextos climáticos, formas e materiais que capacitam soluções sobre energia, água e saneamento que ajudam na obra, através do uso de eco-tecnologias alternativas. É uma revolução e uma filosofia que van Lengen propõe ao homem do século XXI.", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
    }
}
