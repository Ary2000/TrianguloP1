package Triangle.SyntacticAnalyzer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TokenPrinter {

  private Scanner lexicalAnalyser;
  private Token currentToken;

  public TokenPrinter(Scanner lexer) {
    lexicalAnalyser = lexer;
  }

  public void printTokens() {
    currentToken = lexicalAnalyser.scanCodeToHtml();
    while (currentToken.kind != Token.EOT) {
      if (currentToken.kind == Token.INTLITERAL ||
              currentToken.kind == Token.CHARLITERAL ||
              currentToken.kind == Token.IDENTIFIER ||
              currentToken.kind == Token.OPERATOR)
        System.out.println(currentToken.spelling);
      else if(currentToken.kind == -1){
          System.out.println(currentToken.spelling);
      }
      else if(currentToken.kind == -2){
          System.out.println(currentToken.spelling);
      }
      else
        System.out.println(currentToken.toString());
      System.out.print('|');
      currentToken = lexicalAnalyser.scanCodeToHtml();
    }
  }
  public Document printTokensHtml(){
      try {
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          Document doc = dBuilder.newDocument();
          Element html = doc.createElement("html");
          Element head = doc.createElement("head");
          Element title = doc.createElement("title");
          Element body = doc.createElement("body");
          Element paragraph =  doc.createElement("pre");
          Element saltoDeLinea = doc.createElement("br");
          html.setAttribute("lang", "en");
          title.setTextContent("codigo");
          head.appendChild(title);
          html.appendChild(head);
          
          currentToken = lexicalAnalyser.scanCodeToHtml();
          while (currentToken.kind != Token.EOT) {
            if (currentToken.kind == Token.IDENTIFIER ||
                    currentToken.kind == Token.OPERATOR){
                //System.out.println(currentToken.spelling);
                Element var = doc.createElement("font");
                var.setAttribute("color","Black");      
                var.setAttribute("size","3");
                var.setAttribute("face","Courier");
                var.setTextContent(currentToken.spelling);
                paragraph.appendChild(var);
                
            }
            else if(currentToken.kind == Token.CHARLITERAL ||
                    currentToken.kind == Token.INTLITERAL){
                Element var = doc.createElement("font");
                var.setAttribute("color","Blue");      
                var.setAttribute("size","3");
                var.setAttribute("face","Courier");
                var.setTextContent(currentToken.spelling);
                paragraph.appendChild(var);
                
            }
            else if(currentToken.kind == -1){
                //System.out.println(currentToken.spelling);
                Element var = doc.createElement("font");
                var.setAttribute("color","Green");
                var.setAttribute("size","3");
                var.setAttribute("face","Courier");
                var.setTextContent(currentToken.spelling);
                paragraph.appendChild(var);
                
            }
            else if(currentToken.kind == -2){
                //System.out.println(currentToken.spelling.length());
                Element var = doc.createElement("font");
                if(currentToken.spelling.length()==1){
                    var.setTextContent(" ");
                    
                }
                else{
                    var.setTextContent("    ");
                    
                }
                paragraph.appendChild(var);
                
            }
            else if(currentToken.kind == -3){ //salto de linea
                Element var = doc.createElement("font");
                var.setTextContent("\n");
                paragraph.appendChild(var);
                
            }
            else{
                //System.out.println(currentToken.toString());
                Element var = doc.createElement("font");
                Element negrita = doc.createElement("b");
                negrita.setTextContent(currentToken.spelling);
                var.setAttribute("color","Black");
                var.setAttribute("size","3");
                var.setAttribute("face","Courier");
                var.appendChild(negrita);
                paragraph.appendChild(var);
                
            }
            //System.out.print('|');
            currentToken = lexicalAnalyser.scanCodeToHtml();
          }
          body.appendChild(paragraph);
          html.appendChild(body);
          doc.appendChild(html);
          return doc;
      } catch (ParserConfigurationException ex) {
          Logger.getLogger(TokenPrinter.class.getName()).log(Level.SEVERE, null, ex);
      }
      return null;
  }
}