package Triangle.SyntacticAnalyzer;

public class TokenPrinter {

  private Scanner lexicalAnalyser;
  private Token currentToken;

  public TokenPrinter(Scanner lexer) {
    lexicalAnalyser = lexer;
  }

  public void printTokens() {
    currentToken = lexicalAnalyser.scan();

    while (currentToken.kind != Token.EOT) {
      if (currentToken.kind == Token.INTLITERAL ||
              currentToken.kind == Token.CHARLITERAL ||
              currentToken.kind == Token.IDENTIFIER ||
              currentToken.kind == Token.OPERATOR)
        System.out.println(currentToken.spelling);
      else
        System.out.println(currentToken.toString());
      System.out.print('|');
      currentToken = lexicalAnalyser.scan();
    }
  }
}