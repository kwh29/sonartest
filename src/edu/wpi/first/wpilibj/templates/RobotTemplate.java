/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    
    
    public static AnalogChannel sonarSensor;
    public boolean fire;
    public double inches;
    public double cm;
    
    public void robotInit() {
        System.out.println("-sonar_test-");
        sonarSensor = new AnalogChannel(5);
    }
    
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {

           
        while(isEnabled() && isOperatorControl()){
        
            cm = sonarSensor.getAverageVoltage() / .0049;
            inches = cm / 2.54;
            
            if (inches <= 60 && inches >= 48) {
                fire = true;
            } else if (inches  <= 216 && inches >= 228) {
                fire = true;
            } else {
                fire = false;
            }
            
            System.out.println(inches);
            
            SmartDashboard.putNumber("Distance", inches);
            SmartDashboard.putBoolean("Fire", fire);
            
        Timer.delay(0.01);
        }

    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
