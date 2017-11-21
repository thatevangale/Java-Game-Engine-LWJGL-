package evan.game.main;

import static org.lwjgl.glfw.GLFW.glfwGetTime;

public class GameTimer {
	
	private double lastTime;
	private double deltaTime;
	
	private int frameCount;
	//private int updateCount;

	public void init() {
		lastTime = getTime();
	}
	
	public double getTime() {
		return glfwGetTime();
	}
	
	public double getDelta() {
		double currentTime = getTime(); //System.nanoTime() / 1.0e9;
		deltaTime = currentTime - lastTime;
		lastTime = currentTime;
		frameCount++;
		
		if (deltaTime > 1000) {
			deltaTime -= 1000;
			frameCount = 0;
		}
		
		return deltaTime;
		
	}
	
	public int getFrameCount() {
		return frameCount;
	}
	
}
