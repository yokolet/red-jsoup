# -*- ruby -*-

require 'rake/javaextensiontask'

ext_task = Rake::JavaExtensionTask.new do |ext|
  jars = FileList['lib/*.jar']
  ext.name = 'red-jsoup'
  ext.tmp_dir = 'tmp'
  ext.classpath = jars.map {|x| File.expand_path x}.join ':'
  ext.lib_dir << "/#{ext.platform}"
  ext.source_version = '21'
  ext.target_version = '21'
  ext.ext_dir = 'ext/red_jsoup'
end

task :build => "#{ext_task.lib_dir}/#{ext_task.name}.jar"
