package org.oreon.modules.gl.atmosphere;

import org.oreon.core.gl.shaders.GLShader;
import org.oreon.core.scene.GameObject;
import org.oreon.core.util.ResourceLoader;

public class AtmosphereShader extends GLShader{

	private static AtmosphereShader instance = null;
	
	public static AtmosphereShader getInstance() 
	{
		if(instance == null) 
		{
			instance = new AtmosphereShader();
		}
		return instance;
	}
		
	protected AtmosphereShader()
	{
		super();

		addVertexShader(ResourceLoader.loadShader("shaders/atmosphere/atmosphere_VS.glsl"));
		addFragmentShader(ResourceLoader.loadShader("shaders/atmosphere/atmosphere_FS.glsl"));
		compileShader();
			
		addUniform("modelViewProjectionMatrix");
		addUniform("worldMatrix");
	}
		
	public void updateUniforms(GameObject object)
	{
		setUniform("modelViewProjectionMatrix", object.getWorldTransform().getModelViewProjectionMatrix());
		setUniform("worldMatrix", object.getWorldTransform().getWorldMatrix());
	}
}
