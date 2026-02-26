# Comandos e Relatórios do Jacoco (Code Coverage)

## Onde fica o relatório HTML (A Visão Geral)?
Após rodar os testes com sucesso, o Jacoco gera a página da web `index.html` e a pasta `jacoco` repletas com os detalhes de cobertura. 

Você deve abrir esse arquivo usando seu navegador web ou a extensão "Live Server" do VS Code:
👉 **Caminho Exato:** `app/build/reports/jacoco/test/html/index.html`

*Nota: A pasta `build` costuma ficar "escondida" no fundo do VS Code, se você não achar na barra lateral, basta abrir a pasta do seu projeto no explorador do Linux e navegar até `fernandoLimaGradlew/app/build/...`*

---

## Comandos para o Terminal (Na raiz da pasta fernandoLimaGradlew)

Para forçar a geração *apenas* dos relatórios do jacoco e rodar **todos** os testes escritos, rastejando pelo projeto novo sem dar erro no WildFly:

```bash
# Executa todos os testes da aplicação e em seguida sobrepõe relatórios (CSV/XML/HTML) com o Jacoco.
./gradlew :app:test :app:jacocoTestReport
```

*Dica: Se você usar o atalho da extensão Coverage Gutters no VS Code, ela vai rodar esse processo nos bastidores toda vez que você apertar o botão "Watch" da barra roxa!*

---

## Como empacotar (zipar) a Cobertura para o Professor
Como a pasta `build` possui uma quantidade massiva de lixo de execução (compilados, DAOs, caches), o professor se interessa apenas no HTML interativo purificado das suas métricas. 

Para extrair todo o site `html` limpo das masmorras do `build` e transformá-lo num `.zip` solto direto na sua pasta `coverage` atual, rode isso no terminal (estando dentro da pasta raiz `fernandoLimaGradlew`):

```bash
cd app/build/reports/jacoco/test/html && zip -r ../../../../../../src/main/java/coverage/relatorio_jacoco_professor.zip *
```
E bum! Você terá um pacote chamado `relatorio_jacoco_professor.zip` lá junto ao seu `Main.java` pronto para anexar e tirar nota 10.
