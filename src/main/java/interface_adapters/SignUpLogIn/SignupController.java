package interface_adapters.SignUpLogIn;

import UseCase.signup.SignupInputBoundary;
import UseCase.signup.SignupInputData;

public class SignupController {

    final SignupInputBoundary userSignupUseCaseInteractor;
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2) {
        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2);

        userSignupUseCaseInteractor.execute(signupInputData);
    }

    public void executeSwitchScreen(){
        userSignupUseCaseInteractor.executeSwitchScreen();
    }
}
