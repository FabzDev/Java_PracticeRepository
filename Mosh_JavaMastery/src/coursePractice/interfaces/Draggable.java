package coursePractice.interfaces;

public interface Draggable extends Renderable, Resizable{
	void drag();
	void drag(int x,int y);
	void drag(Renderable widObj);
}

