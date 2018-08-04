package dao_interfaces;

/** LoginInterface
 * This Interface defines the login method
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/27/2018 */
public interface LoginInterface {
    /** LoginInterface manager */
    boolean login(String username, String password, String type);
}//end interface LoginInterface
