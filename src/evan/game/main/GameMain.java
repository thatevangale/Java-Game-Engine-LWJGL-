package evan.game.main;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWVidMode;

public class GameMain {
	
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	
	private boolean running = false;
	
	private long windowID;
	
	private GLFWKeyCallback keyCallback;
	private GLFWCursorPosCallback cursorCallback;
	
	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.run();
	}
	
	public void run() {
		init();
		
		while (running) {
			update();
			render();
			
			if (glfwWindowShouldClose(windowID)) {
				running = false;
			}
		}
		
		dispose();
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
		
		glfwSetKeyCallback(windowID, keyCallback = new GameKeyboardInput());
		glfwSetCursorPosCallback(windowID, cursorCallback = new GameMouseInput());
		
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		
		glfwSetWindowPos(windowID, 100, 100);
		
		glfwMakeContextCurrent(windowID);
		
		glfwShowWindow(windowID);
	}
	
	public void update() {
		glfwPollEvents();
		
		if (GameKeyboardInput.isKeyDown(GLFW_KEY_SPACE)) {
			System.out.println("Spacebar");
		}
	}
	
	public void render() {
		glfwSwapBuffers(windowID);
	}
	
	private void dispose() {
		glfwDestroyWindow(windowID);
		glfwTerminate();
		System.exit(0);
	}
	
}
