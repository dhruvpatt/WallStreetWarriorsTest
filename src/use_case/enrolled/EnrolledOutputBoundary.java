package use_case.enrolled;

/**
 *
 *
 *
 *
 * @author Mikhail Skazhenyuk
 * @version 0.0
 */
public interface EnrolledOutputBoundary {
    void prepareSuccessView(EnrolledOutputData enrolledOutputData);

    // void prepareFailView() TODO Incase maybe contest failed to retrieve?
}
