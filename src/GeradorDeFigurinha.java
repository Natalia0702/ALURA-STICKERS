import java.io.File;
//import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GeradorDeFigurinha {

    public void cria() throws Exception {
        // [] Leitura de imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/filmes.jpg"));
        InputStream inputStream = 
                            new URL("https://s1.static.brasilescola.uol.com.br/be/conteudo/images/imagem-em-lente-convexa.jpg")
                            .openStream();
        BufferedImage ImagemOriginal = ImageIO.read(inputStream);

        // [] Cria nova imagem em memória com transparência e com tamanho novo
        int largura = ImagemOriginal.getWidth();
        int altura = ImagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        // [] Copiar a imagem original par a anova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(ImagemOriginal, 0, 0, null);

        // [] Configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 60);
        graphics.setColor(Color.CYAN);
        graphics.setFont(fonte);

        // [] Escrever uma frase na nova imagem
        graphics.drawString("Imersão Java", 0, novaAltura - 100);

        // [] Escrever a nova imagem em um aruivo
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
    }

    public static void main(String[] args) throws Exception {
        var geradora = new GeradorDeFigurinha();
        geradora.cria();
    }
}
