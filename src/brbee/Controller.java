package brbee;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*******************************************************************************
*   Author: Jarek Thomas
*   Last Edited: 12/06/2015 
*   
*   Description: Responsible for maintaining the flow of the program.
*******************************************************************************/

public class Controller {
    
    /***************************************************************************
    *                           DECLARE VARIABLES
    ***************************************************************************/
    private JPanel cards;
    private CardLayout cardLayout;
    private CreateProfile createProfile;
    private EditProfile editProfile;
    private LoadProfile loadProfile;
    private SearchProfiles search;
    private Theatre theatre;
    private MainMenu mainMenu;
    private final static String MAIN_MENU = "MAIN_MENU";
    private final static String CREATE_PROFILE = "CREATE_PROFILE";
    private final static String EDIT_PROFILE = "EDIT_PROFILE";
    private final static String LOAD_PROFILE = "LOAD_PROFILE";
    private final static String THEATRE = "THEATRE";
    
    
    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }
    /***************************************************************************
    *                         GUI CONSTRUCTION METHOD
    ***************************************************************************/
    public static void createGUI() {
        
        JFrame frame = new JFrame("BRBee");
        
        Controller controller = new Controller();
        controller.addComponentToPane(frame.getContentPane());
       
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /***************************************************************************
    *                         ADD COMPONENTS TO PANE
    ***************************************************************************/
    public void addComponentToPane(Container pane) {
        
        this.theatre = new Theatre(this);
        this.createProfile = new CreateProfile(this, this.theatre);
        this.editProfile = new EditProfile(this, this.theatre);
        this.loadProfile = new LoadProfile(this, this.theatre);
        this.search = new SearchProfiles(this.loadProfile, this.editProfile);
        this.mainMenu = new MainMenu(this, this.createProfile);
        
        
        cards = new JPanel (new CardLayout());
        cards.add(mainMenu, MAIN_MENU);
        cards.add(createProfile, CREATE_PROFILE);
        cards.add(editProfile, EDIT_PROFILE);
        cards.add(loadProfile, LOAD_PROFILE);
        cards.add(theatre, THEATRE);
        
        pane.add(cards, BorderLayout.CENTER);
        
        
        cardLayout = (CardLayout)(cards.getLayout());
        cardLayout.show(cards, MAIN_MENU);
    }
    /***************************************************************************
    *                         UPDATE PROFILES
    ***************************************************************************/
    public void updateProfiles(){
        search.populateList();
    }
    
    public void deleteElement(Integer index){
        loadProfile.deleteElement(index);
    }
    /***************************************************************************
    *                     METHODS TO CHANGE SELECTED CARD
    ***************************************************************************/
    public void firstCard() {
        cardLayout.first(cards);
    }
    public void lastCard() {
        cardLayout.last(cards);
    }
    public void nextCard() {
        cardLayout.next(cards);
    }
    public void previousCard() {
        cardLayout.previous(cards);
    }
    public void showCard(String name) {
        cardLayout.show(cards, name);
    }
}
