import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class VisualizerTest {
	

	@Test
	public void test() {
		viewFloor v1=mock(viewFloor.class);
		when(v1.floorSize()).thenReturn(7);
		Visualizer vs=new Visualizer();
		
	}

}
