# -*- ruby -*-

require 'rake/javaextensiontask'

jars = Dir.glob("lib/**/*.jar")
Rake::JavaExtensionTask.new do |ext|
  ext.name = 'red-jsoup'
  ext.tmp_dir = 'tmp'
  ext.classpath = jars.map {|x| File.expand_path x}.join ":"
  ext.source_version = '21'
  ext.target_version = '21'
  ext.ext_dir = 'ext/red_jsoup'
end

task :default => [:compile]
