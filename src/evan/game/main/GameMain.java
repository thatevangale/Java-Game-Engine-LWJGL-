package evan.game.main;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;
import org.lwjgl.glfw.GLFWVidMode;

public class GameMain {
	
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	
	private boolean running = false;
	
	private long windowID;
	
	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.run();
	}
	
	public void run() {
		init();
		
		while (running) {
			//input();
			update();
			render();
			
			if (glfwWindowShouldClose(windowID)) {
				running = false;
			}
		}
		
		dispose();
		
		glfwDestroyWindow(windowID);
		glfwTerminate();
		System.exit(0);
	}

	public void init() {
		this.running = true;
		
		if (!glfwInit()) {
			System.err.println("Error: GLFW initialization failed");
			System.exit(-1);
		}
		
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		
		windowID = glfwCreateWindow(WIDTH, HEIGHT, "Pong", NULL, NULL);
		
		if (windowID == NULL) {
			System.err.println("Error: Game window code could not be created");
		}
		
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		
		glfwSetWindowPos(windowID, 100, 100);
		
		glfwMakeContextCurrent(windowID);
		
		glfwShowWindow(windowID);
	}
	
	public void input() {}
	
	public void update() {
		glfwPollEvents();
	}
	
	public void render() {
		glfwSwapBuffers(windowID);
	}
	
	private void dispose() {}
	
}
