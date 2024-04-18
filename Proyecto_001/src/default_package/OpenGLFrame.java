package default_package;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLJPanel;

public class OpenGLFrame extends JFrame implements GLEventListener{

	private static final long serialVersionUID = 1L;
	private GLJPanel glJPanel;
	private String typeGraph = "Circle";

	OpenGLFrame(String title, int width, int height) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocation(270, 65);
		this.setLayout(new GridLayout(0,2));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton btn1 = new JButton("Triángulo");
		btn1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawing("Triangle");
			}
		});
		panel.add(btn1);
		
		JButton btn2 = new JButton("Cuadrado");
		btn2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawing("Square");
			}
		});
		panel.add(btn2);
		
		JButton btn3 = new JButton("Círculo");
		btn3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawing("Circle");
			}
		});
		panel.add(btn3);
		
		this.add(panel);

		glJPanel = new GLJPanel();
		glJPanel.addGLEventListener(this);		
		this.add(glJPanel);
		this.setVisible(true);
	}

	public void drawing(String type) {
		typeGraph = type;
		display(glJPanel);
	}
	
	public void init(GLAutoDrawable drawable) {

	}

	public void display(GLAutoDrawable drawable) {		
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		if(typeGraph.equals("Triangle")) {
			gl.glBegin(GL.GL_TRIANGLES);
			gl.glVertex3f(-0.5f, -0.5f, 0.0f);
			gl.glVertex3f(0.0f, 0.5f, 0.0f);
			gl.glVertex3f(0.5f, -0.5f, 0.0f);
			gl.glEnd();
		}else {
			if(typeGraph.equals("Square")) {
				gl.glBegin(GL2.GL_QUADS);
				gl.glVertex3f( 0.5f,0.5f,0);
				gl.glVertex3f(-0.5f,0.5f,0);
				gl.glVertex3f(-0.5f,-0.5f,0);
				gl.glVertex3f(0.5f,-0.5f,0);
				gl.glEnd();
			}else {
				gl.glBegin(GL2.GL_POLYGON);
				int numVertices = 100;
		        double radius = 0.5;
				double angle = 0;
	            double angleIncrement = 2 * Math.PI / numVertices;
	            for (int i = 0; i < numVertices; i++) {
	                angle = i * angleIncrement;
	                double x = radius * Math.cos(angle);
	                double y = radius * Math.sin(angle);
	                gl.glVertex2d(x, y);
	            }
				gl.glEnd();
			}
		}
		glJPanel.repaint();
		
	}

	public void dispose(GLAutoDrawable drawable) {
		
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		
	}
}

