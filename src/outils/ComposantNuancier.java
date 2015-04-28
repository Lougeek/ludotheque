package outils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; 

/** Cette classe impl�mente un nuancier permettant, par un clic de souris, de s�lectionner une couleur. La s�lection de la couleur est notifi�e aux observer qui ont �t� ajout�s � l'instance par appel de observer.update(null,Color c) o� c est la couleur s�lectionn�e dans le nuancier. */
public class ComposantNuancier extends Canvas{
 
  private int dim;
  private Color currentColor;
  private Rectangle[] carreaux;
  private Color[] couleurCarreaux;
  private LinkedList ob;
 
  /** Constructeur. dim est la r�solution du nuancier. */
  public  ComposantNuancier(int dim){
    this.dim = dim;
    this.ob = new LinkedList();
    this.currentColor = Color.BLACK;
    this.carreaux  = new Rectangle[dim * dim];
    this.couleurCarreaux = new Color[dim * dim];
    for(int i = 0; i < dim; i++){      
      // Premi�re boucle r�alisant un fondu du noir vers la teinte (moiti� sup�rieure)
      int j;
      for(j = 0; j < dim / 2; j++)
        // Teinte, Saturation, Luminosite
        couleurCarreaux[i * dim + j] = Color.getHSBColor((float)i / dim,1,(float)j / dim * 2);
      // Seconde boucle diminuant la saturation de la couleur (moiti� inf�rieure)
      for( ; j < dim; j++)
        couleurCarreaux[i * dim + j] = Color.getHSBColor((float)i / dim,(float)(dim - 1 - j) / dim * 2,1);
    }
    this.enableEvents(AWTEvent.MOUSE_EVENT_MASK);
  }

  /** M�thode appel�e quand le composant change de dimension */
  public void setBounds(int x, int y, int width, int height){
    super.setBounds(x, y, width, height);
    // Calcul de la largeur et de la hauteur des carreaux
    int largeur = this.getSize().width  / dim;
    int hauteur = this.getSize().height / dim;
    // Cr�ation des rectangles repr�sentant les carreaux de couleur
    for(int i = 0; i < dim; i++)
      for(int j = 0; j < dim; j++)
        carreaux[i * dim + j] = new Rectangle(largeur * i, hauteur * j, largeur, hauteur);
  }
 
  public void paint(Graphics gc){
    for(int i = 0; i < carreaux.length; i++){
      gc.setColor(couleurCarreaux[i]);
      gc.fillRect(carreaux[i].x,carreaux[i].y,carreaux[i].width,carreaux[i].height);
    }
  }
 
  public void processMouseEvent(MouseEvent e){
    if(e.getID() == MouseEvent.MOUSE_CLICKED){
      for (int i = 0; i < carreaux.length; i++){
        if (carreaux[i].contains(e.getX(),e.getY())){
          this.currentColor = couleurCarreaux[i];
          if(this.ob != null){
            for(Iterator it = this.ob.iterator();it.hasNext();)
              ((Observer) it.next()).update(null,this.currentColor);
          }
        }
      }
    }
  }

  public void addObserver(Observer obs){ 
    if(obs != null) this.ob.add(obs);
  }
  
  public void removeObserver(Observer obs){
    if(obs != null) this.ob.remove(obs);
  }
   
  //public Color getCurrentColor(){return this.currentColor;}

  public static void  main(String[] arg){
    JFrame jf = new JFrame("Nuancier");
    jf.getContentPane().add(new ComposantNuancier(100));
    jf.setVisible(true);
    jf.pack();
  }

}