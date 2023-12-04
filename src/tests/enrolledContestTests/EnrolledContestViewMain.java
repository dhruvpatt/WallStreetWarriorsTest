package EnrolledContestTests;

import firebaseDataAccess.FirebaseDataAccess;
import app.ContestUseCaseFactory;
import app.Main;
import com.google.cloud.firestore.Firestore;
import entity.Contest;
import interfaceAdapters.Enrolled.EnrolledViewModel;
import interfaceAdapters.ViewModelManager;
import view.EnrolledContest.EnrolledView;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EnrolledContestViewMain {


    public static void main(String[] args) {
        // initialization for firebase.
        Firestore db;

        try{
            Main.FirebaseInit();
            var firebaseDataAccess = FirebaseDataAccess.getInstance();
            // catching exceptions for GoogleCredentials.fromStream and FileInputStream
            String contestId = "EnrolledTest";
            Contest enrolled = firebaseDataAccess.getEntity(Contest.class, "Contests", contestId);

            // creating JFrame for app
            JFrame app = new JFrame("Wall Street Warriors");
            app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            app.setSize(new Dimension(800, 600));

            CardLayout cardLayout = new CardLayout();
            JPanel views = new JPanel(cardLayout);
            app.add(views);
            ViewModelManager viewModelManager = new ViewModelManager();

            EnrolledViewModel enrolledViewModel = new EnrolledViewModel();

            EnrolledView enrolledView = ContestUseCaseFactory.createEnrolledView(enrolledViewModel, firebaseDataAccess, viewModelManager, contestId, "a");

            viewModelManager.setActiveView(enrolledView.viewName);
            viewModelManager.firePropertyChanged();

            enrolledView.pack();
            enrolledView.setVisible(true);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } {
            System.out.println("Unable to load firebase data, app will have limited functionality");
        }

    }
}
