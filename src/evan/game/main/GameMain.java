package evan.game.main;

public class GameMain {
	
	private static final long serialVersionUID = 1L;
	
	public static final int TARGET_FPS = 60;
	public static final int TARGET_UPS = 30;
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	protected boolean running;
	
	protected GameWindow window;
	
	protected GameTimer timer;
	
	protected GameRenderer renderer;
	
	public GameMain() {
		timer = new GameTimer();
		renderer = new GameRenderer();
	}

	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.start();
	}

	public void start() {
		init();
		gameLoop();
		dispose();
	}

	private void init() {
		timer.init();
		running = true;
	}

	public void gameLoop() {
		double delta;
        double accumulator = 0.0;
        double interval = 1.0 / TARGET_UPS;
        double alpha;

        while (running) {
            /* Check if game should close */
            if (window.isClosing()) {
                running = false;
            }

            /* Get delta time and update the accumulator */
            delta = timer.getDelta();
            accumulator += delta;

            /* Handle input */
            input();

            /* Update game and timer UPS if enough time has passed */
            while (accumulator >= interval) {
                update(interval);
                //timer.updateUPS();
                accumulator -= interval;
            }

            /* Calculate alpha value for interpolation */
            alpha = accumulator / interval;

            /* Render game and update timer FPS */
            render(alpha);
            //timer.updateFPS();

            /* Update timer */
            //timer.update();
        }
    }
	
	private void input() {
		// TODO Auto-generated method stub
		
	}
	
	private void update(double interval) {
		// TODO Auto-generated method stub
		
	}
	
	private void render(double alpha) {
		// TODO Auto-generated method stub
		
	}

	private static void dispose() {
		// TODO Auto-generated method stub
		
	}

}
