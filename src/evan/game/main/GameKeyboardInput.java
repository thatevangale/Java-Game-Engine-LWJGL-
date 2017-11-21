package evan.game.main;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWKeyCallback;

public class GameKeyboardInput extends GLFWKeyCallback {
	
	public static final int KEYS_SIZE = 256;
	public static boolean[] keys = new boolean[KEYS_SIZE];
	
	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		keys[key] = action != GLFW_RELEASE;
	}
	
	public static boolean isKeyDown(int k) {
		return keys[k];
	}
	
}
